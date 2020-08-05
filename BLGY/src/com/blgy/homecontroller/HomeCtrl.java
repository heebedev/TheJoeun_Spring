package com.blgy.homecontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blgy.command.AdminMainCommand;
import com.blgy.command.AdminProductCommand;
import com.blgy.command.AdminProductDeleteCommand;
import com.blgy.command.AdminProductModifyCommand;
import com.blgy.command.AdminProductModifyGetInfoCommand;
import com.blgy.command.AdminProductSearchCommand;
import com.blgy.command.AdminUserCommand;
import com.blgy.command.AdminUserDeleteCommand;
import com.blgy.command.AdminUserModifyCommand;
import com.blgy.command.AdminUserModifyGetInfoCommand;
import com.blgy.command.AdminUserSearchCommand;
import com.blgy.command.AuthorizeCmd;
import com.blgy.command.BAddProductCommand;
import com.blgy.command.BCommand;
import com.blgy.command.BMyBorrowListCommand;
import com.blgy.command.BMyProductListCommand;
import com.blgy.command.BborrowCommand;
import com.blgy.command.BcommentAddCommand;
import com.blgy.command.BcommentCheckCommand;
import com.blgy.command.BcommentRUDCommand;
import com.blgy.command.BmessageCommand;
import com.blgy.command.BmessageListCommand;
import com.blgy.command.BpdDetailCommand;
import com.blgy.command.BprdCheckCommand;
import com.blgy.command.BprdRUDCommand;
import com.blgy.command.DupChkCmd;
import com.blgy.command.FindAccCmd;
import com.blgy.command.FindPwCmd;
import com.blgy.command.ImportPrivacycmd;
import com.blgy.command.KLoginCommand;
import com.blgy.command.LikeCommand;
import com.blgy.command.MainCommand;
import com.blgy.command.MyLikeCmd;
import com.blgy.command.ReassignPwCmd;
import com.blgy.command.SCommand;
import com.blgy.command.SearchCommand;
import com.blgy.command.SignUpCommand;
import com.blgy.command.UpdateUserData;
import com.blgy.command.ValidationCmd;
import com.blgy.command.ViewCommand;
import com.blgy.command.importCommand;

@WebServlet("*.bill")
public class HomeCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HomeCtrl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		String viewPage = null;
		BCommand command = null;
		SCommand scommand = null;

		switch (com) {
		
		case("/messageWin.bill") :
			command = new BmessageCommand();
			command.execute(request, response);
			viewPage = "messageConfirm.jsp";
			break;

		case ("/logOut.bill"):
			viewPage = "logOut.jsp";
			break;

		case ("/mainpage.bill"):
			viewPage = "Main.jsp";
			break;
			
		case ("/mainpage2.bill"):
			viewPage = "Main.jsp";
			break;
			
		case("/Mainpage.bill"):
			scommand = new MainCommand();
			scommand.execte(request, response);
			viewPage = "MainForm.jsp";
			break;

		case ("/signUp.bill"):
			viewPage = "CreateAcc1.jsp";
			break;

		case ("/signUp2.bill"):
			viewPage = "CreateAcc2.jsp";
			break;

		case ("/accCheck.bill"):
			viewPage = "accCheck.jsp";
			break;

		case ("/duplicate.bill"):
			command = new DupChkCmd();
			command.execute(request, response);
			viewPage = "validation4.jsp";
			break;

		case ("/createAcc.bill"):
			command = new SignUpCommand();
			command.execute(request, response);
			viewPage = "AccCreated.jsp";
			break;

		case ("/login.bill"):
			viewPage = "LoginForm.jsp";
			break;

		case ("/Login.bill"):
			command = new ValidationCmd();
			command.execute(request, response);
			viewPage = "validation.jsp";
			break;

		case ("/kakaoLogin.bill"):
			command = new KLoginCommand();
			command.execute(request, response);
			viewPage = "validation.jsp";
			break;

		case ("/invalidRequest.bill"):
			viewPage = "login.bill";
			break;

		case ("/FindPw.bill"):
			viewPage = "FindPw.jsp";
			break;

		case ("/FindAcc.bill"):
			viewPage = "FindAcc.jsp";
			break;

		case ("/importInfo.bill"):
			command = new importCommand();
			command.execute(request, response);
			viewPage = "Login.jsp";
			break;

		case ("/findAcc.bill"):
			command = new FindAccCmd();
			command.execute(request, response);
			viewPage = "validation3.jsp";
			break;

		case ("/findPw.bill"):
			command = new FindPwCmd();
			command.execute(request, response);
			viewPage = "validation2.jsp";
			break;

		case ("/resetPw.bill"):
			command = new ReassignPwCmd();
			command.execute(request, response);
			viewPage = "pwChanged.jsp";
			break;

		case ("/MyProductList.bill"):
			command = new BMyProductListCommand();
			command.execute(request, response);
			viewPage = "MyProductList.jsp";
			break;
			
		case ("/ProductList.bill"):
			command = new BMyProductListCommand();
			command.execute(request, response);
			viewPage = "ProductList.jsp";
			break;

		case ("/AddProduct.bill"):
			viewPage = "AddProduct.jsp";
			break;

		case ("/actionAddedProduct.bill"):
			command = new BAddProductCommand();
			command.execute(request, response);
			viewPage = "posted.jsp";
			break;

		case ("/MyborrowList.bill"):
			command = new BMyBorrowListCommand();
			command.execute(request, response);
			viewPage = "MyBorrowList.jsp";
			break;
			
		case ("/MyInterestList.bill"):
			command = new MyLikeCmd();
			command.execute(request, response);
			viewPage = "MyInterestList.jsp";
			break;

		case ("/admin.bill"):
			viewPage = "MyBorrowList.jsp";
			break;
			
		case ("/authority.bill"):
			viewPage = "authority.jsp";
			break;
		
		case ("/authorize.bill"):
			command= new AuthorizeCmd();
			command.execute(request, response);
			viewPage = "validation5.jsp";
			break;
			
		case ("/privateinfo.bill"):
			command= new ImportPrivacycmd();
			command.execute(request, response);
			viewPage = "AccInfo.jsp";
			break;

		case ("/updateuserdata.bill"):
			command= new UpdateUserData();
			command.execute(request, response);
			viewPage = "updated.jsp";
			break;
		
		case("/productDetail.bill") :
			command = new BpdDetailCommand();
			command.execute(request, response);
			viewPage = "productDetail.jsp";
			break;

		
		case("/message.bill") :
			//System.out.println("BmessageListCommand");
			command = new BmessageListCommand();
			command.execute(request, response);
			viewPage = "messageFinal.jsp";
			break;
		case("/commentAdd.bill") :
			//System.out.println("commentAddCommand");
			command = new BcommentAddCommand();
			command.execute(request, response);
			viewPage = "commentConfirm.jsp";
			break;
		case("/cmtRev.bill") :
			//System.out.println("commentRUDCommand - Rev");
			command = new BcommentRUDCommand();
			command.execute(request, response);
			viewPage = "commentRevConfirm.jsp";
			break;
		case("/cmtDel.bill") :
			//System.out.println("commentRUDCommand - Del");
			command = new BcommentRUDCommand();
			command.execute(request, response);
			viewPage = "commentRevConfirm.jsp";
			break;
		case("/commentCheck.bill") :
			//System.out.println("commentCheckCommand");
			command = new BcommentCheckCommand();
			command.execute(request, response);
			viewPage = "commentCheck.jsp";
			break;
		case("/borrow.bill") :
			//System.out.println("borrwoCommand");
			command = new BborrowCommand();
			command.execute(request, response);
			viewPage = "borrowConfirm.jsp";
			break;
		case("/prdDel.bill") :
			//System.out.println("prdRUDCommand - Del");
			command = new BprdRUDCommand();
			command.execute(request, response);
			viewPage = "prdDelConfirm.jsp";
			break;
		case("/prdCheck.bill") :
			//System.out.println("prdCheckCommand");
			command = new BprdCheckCommand();
			command.execute(request, response);
			viewPage = "prdCheck.jsp";
			break;	
		case("/prdRev.bill") :
			//System.out.println("prdRUDCommand");
			command = new BprdRUDCommand();
			command.execute(request, response);
			viewPage = "postupdated.jsp";
			break;
		case("/dm.bill"):
			viewPage = "messageSendDirect.jsp";
			break;
		case("/nm.bill"):
			viewPage = "messageSend.jsp";
			break;
		case("/sendmessage.bill"):
			//System.out.println("여기");
			command = new BmessageCommand();
			command.execute(request, response);
			viewPage ="message.bill";
			break;
		case("/SearchAfter.bill"):
			scommand = new SearchCommand();
			scommand.execte(request, response);
			//System.out.println("홈컨트롤러 execte.");
			viewPage = "SearchAfter.jsp";
			//System.out.println("홈컨트롤러 viewPageg.");
			break;
		case("/Like.bill"):				
			scommand = new LikeCommand();
			scommand.execte(request, response);
			//System.out.println("홈컨트롤러 execte.");
			viewPage = "LikeForm.jsp";
			//System.out.println("홈컨트롤러 viewPage.");
			break;
		case("/View.bill"):
			scommand = new ViewCommand();
			scommand.execte(request, response);
			//System.out.println("홈컨트롤러 execte.");
			viewPage = "productDetail.bill";
			//System.out.println("홈컨트롤러 viewPage.");
			break;	
			
	///////////////////////Admin///////////////////////////
	// admin 메인페이지 
		case("/adminmain.bill"):
			command = new AdminMainCommand(); 
			command.execute(request, response);
			viewPage = "AdminMainpage.jsp";
			break;	
		
		// admin 회원관리 리스트
		case("/adminUser.bill"):
			command = new AdminUserCommand(); 
			command.execute(request, response);
			viewPage = "AdminUser.jsp";
			break;
			
		// admin 회원검색
		case("/adminusersearch.bill"):
			command = new AdminUserSearchCommand(); 
			command.execute(request, response);
			viewPage = "AdminUserSearch.jsp";
			break;
		
		//수정(view)
		case("/adminuserview.bill"):
			command = new AdminUserModifyGetInfoCommand();
			command.execute(request, response);
			viewPage = "AdminUserView.jsp";
			break;
			
		case("/adminusermodify.bill"):
			command = new AdminUserModifyCommand();
			command.execute(request, response);
			viewPage = "adminUser.bill";
			break;
		
		
		case("/adminuserdelete.bill"):
			command = new AdminUserDeleteCommand();  
			command.execute(request, response);
			viewPage = "adminUser.bill";
			break;
			
			
		//어드민 상품관리 리스트
		case("/adminproductlist.bill"):
			command = new AdminProductCommand();
			command.execute(request, response);
			viewPage = "AdminProductList.jsp";
			break;
			
		// admin 상품검색
		case("/adminproductsearch.bill"):
			command = new AdminProductSearchCommand(); /////////////
			command.execute(request, response);
			viewPage = "AdminProductSearch.jsp";
			break;
			
		//상품관리 view
		case("/adminproductview.bill"):
			command = new AdminProductModifyGetInfoCommand(); 
			command.execute(request, response);
			viewPage = "AdminProductView.jsp";//
			break;
			
		//어드민 상품관리 수정cmd
		case("/adminproductmodify.bill"):
			command = new AdminProductModifyCommand(); 
			command.execute(request, response);
			viewPage = "adminproductlist.bill";
			break;
			
		//어드민 상품관리 삭제
		case("/adminproductdelete.bill"):
			command = new AdminProductDeleteCommand();  
			command.execute(request, response);
			viewPage = "adminproductlist.bill";
			break;	
			
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
