package com.example.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.model.UserInfo;
import com.example.model.UserInfoHandler;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Inside doGet method");
        // Handle language selection
        String lang = request.getParameter("lang");
        if (lang != null && (lang.equals("en") || lang.equals("zh_CN"))) {
            System.out.println("Selected language: " + lang);

            // Set the selected language in the session
            HttpSession session = request.getSession();
            session.setAttribute("language", lang);

            // Load ResourceBundle for the selected language
            ResourceBundle messages = ResourceBundle.getBundle("messages", new Locale(lang));
            System.out.println("messages is" + messages);
            session.setAttribute("messages", messages);
            
            
            Enumeration<String> keys = messages.getKeys();
            while (keys.hasMoreElements()) {
                String key = keys.nextElement();
                String value = messages.getString(key);
                System.out.println(key + ": " + value);
            }

            System.out.println("ResourceBundle for language " + lang + " loaded successfully.");
            
        } else {
            System.out.println("Invalid language selection.");
        }

        // Redirect back to the login page
    
        response.sendRedirect(request.getContextPath() + "/Login.jsp");
    }

//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        System.out.println("Inside doGet method");
//        // Handle language selection
//        String lang = request.getParameter("lang");
//        if (lang != null && (lang.equals("en") || lang.equals("zh_CN"))) {
//            System.out.println("Selected language: " + lang);
//
//            // Set the selected language in the session
//            HttpSession session = request.getSession();
//            session.removeAttribute("messages");
//            session.setAttribute("language", lang);
//
//            // Load ResourceBundle for the selected language
//            String resourceBundleName = "messages_" + lang;
//            ResourceBundle messages = ResourceBundle.getBundle(resourceBundleName, new Locale(lang));
//            System.out.println("ResourceBundle for language " + lang + " loaded from file: " + messages.getBaseBundleName());
//            session.setAttribute("messages", messages);  
//
//            System.out.println("ResourceBundle for language " + lang + " loaded successfully.");
//        } else {
//            System.out.println("Invalid language selection.");
//        }
//
//        // Redirect back to the login page
//        response.sendRedirect(request.getContextPath() + "/Login.jsp");
//          }

    
    
      
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // Get the values from Login.jsp
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("login page username and password is" + username + password);
        
        UserInfoHandler uif = new UserInfoHandler();
        UserInfo u_info = uif.loginaction(username,password);
        
        System.out.println("u_info is " + u_info);
        
//        System.out.println("user details are " + u_info.getUsername() + u_info.getPassword() + u_info.getName() + u_info.getRole() + u_info.getRoleInt());

        // Check if the username and password are valid

            if (u_info != null && u_info.username.equals(username) && u_info.password.equals(password)) {
                System.out.println("reached here  at if");
                // Login successful, you can set a session attribute to remember the user
                // For example, you can store the username in the session
                HttpSession session = request.getSession();
                session.setAttribute("loggedInUser", username);
                
                // Store the user object in the session
                session.setAttribute("userObject", u_info);

                // Redirect to the welcome page upon successful login
                response.sendRedirect(request.getContextPath() + "/Welcome.jsp");
            } else {
                System.out.println("reached here");
                // Login failed, you can forward back to the login page with an error message
                request.setAttribute("errorMessage", "Invalid username or password");
                request.getRequestDispatcher("/Login.jsp").forward(request, response);
            }
        } 

        
	}
