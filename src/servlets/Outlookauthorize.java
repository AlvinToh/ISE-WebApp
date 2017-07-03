package servlets;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.outlook.dev.auth.AuthHelper;
import com.outlook.dev.auth.IdToken;
import com.outlook.dev.auth.TokenResponse;
import com.outlook.dev.service.OutlookService;
import com.outlook.dev.service.OutlookServiceBuilder;
import com.outlook.dev.service.OutlookUser;

/**
 * Servlet implementation class Outlookauthorize
 */
@WebServlet("/Outlookauthorize")
public class Outlookauthorize extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Outlookauthorize() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    	      throws ServletException, IOException {
    	String code = (String) request.getParameter("code");
		String idToken = (String) request.getParameter("id_token");
		String state = (String) request.getParameter("state");
		
    	HttpSession session = request.getSession();
        UUID expectedState = (UUID) session.getAttribute("expected_state");
        String expectedStateS = expectedState.toString();
        UUID expectedNonce = (UUID) session.getAttribute("expected_nonce");
        

        // Make sure that the state query parameter returned matches
        // the expected state
        if (state.equals(expectedState.toString())) {
        	IdToken idTokenObj = IdToken.parseEncodedToken(idToken, expectedNonce.toString());
        	if (idTokenObj != null) {
        	  TokenResponse tokenResponse = AuthHelper.getTokenFromAuthCode(code, idTokenObj.getTenantId());
        	  session.setAttribute("accessToken", tokenResponse.getAccessToken());
        	  session.setAttribute("userConnected", true);
        	  session.setAttribute("userName", idTokenObj.getName());
        	  session.setAttribute("tokens", tokenResponse);
        	// Get user info
        	  OutlookService outlookService = OutlookServiceBuilder.getOutlookService(tokenResponse.getAccessToken(), null);
        	  OutlookUser user;
        	  try {
        	    user = outlookService.getCurrentUser().execute().body();
        	    session.setAttribute("userEmail", user.getMail());
        	  } catch (IOException e) {
        	    session.setAttribute("error", e.getMessage());
        	  }
        	  session.setAttribute("userTenantId", idTokenObj.getTenantId());
        	} else {
        	  session.setAttribute("error", "ID token failed validation.");
        	}
        }
        else {
          session.setAttribute("error", "Unexpected state returned from authority.");
        }
        response.sendRedirect("outlookauthorize.jsp");
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
