package bookmarket.controller;

import bookmarket.model.BookStotage;
import bookmarket.model.Cart;
import bookmarket.view.ConsoleView;
import bookmarket.user.*;

public class BookMarketController {
	client client = new client();
	admin admin = new admin();
	ConsoleView view;
	BookStotage mBookStorage;// model이란 의미로 접두사 m
	Cart mCart;
	String[] aMenuList = { "0. 로그아웃", "1. 도서 추가", "2. 도서 삭제", "3. 도서 정보 수정" };
	String[] cMenuList = { "0. 로그아웃", "1. 도서 정보 보기", "2. 장바구니 보기", "3. 장바구니 도서 담기", "4. 장바구니 편집", "5. 장바구니 비우기" };

	public BookMarketController() {
	}// default constructor

	public BookMarketController(BookStotage bookStotage, Cart cart, ConsoleView view) {
		this.mBookStorage = bookStotage;
		this.mCart = cart;
		this.view = view;
	}

	public void start() {
		int mode;
		do {
			mode = view.select();
			switch (mode) {
			case 1:
				view.showMessage("사용자 모드를 선택하셨습니다.");
				if (!loginClient()) {
					view.showMessage("아이디 혹은 비밀번호를 잘못 입력하셨습니다.");
					break;
				} else {
					view.displayWelcome();
					clientMenu();
				}
				break;
			case 2:
				view.showMessage("관리자 모드를 선택하셨습니다.");
				if (!loginAdmin()) {
					view.showMessage("틀렸습니다.");
					break;
				} else {
					view.showMessage("관리자모드로 접근");
					adminMenu();
					break;
				}
			}
		} while (mode != 0);
		view.showMessage("북마켓을 종료합니다.");
	}

	private boolean loginClient() {
		String id = view.inputString("id를 입력해주세요. : ");
		String pw = view.inputString("비밀번호를 입력해주세요. : ");
		return client.login(id, pw);
	}

	private void adminMenu() {
		int menu;
		do {
			menu = view.selectMenu(aMenuList);

			switch (menu) {
			case 1 -> {
				addItem2List();
				break;
			}
			case 2 -> {
				removeItem();
				break;
			}
			case 3 -> {
				editItem();
				break;
			}
			}
		} while (menu != 0);
		view.showMessage("로그아웃되었습니다.");
	}

	private void editItem() {
		// TODO Auto-generated method stub
		
	}

	private void removeItem() {
		// TODO Auto-generated method stub
		
	}

	private void addItem2List() {
		// TODO Auto-generated method stub
		
	}

	private void clientMenu() {
		int menu;
		do {
			menu = view.selectMenu(cMenuList);

			switch (menu) {
			case 1 -> {
				viewBookInfo();
				break;
			}
			case 2 -> {
				viewCart();
				break;
			}
			case 3 -> {
				addBook2Cart();
				break;
			}
			case 4 -> {
				removeCartItem();
				break;
			}
	 		case 5 -> {
	 			resetCart();	 			
	 			break;
	 		}
			}
		} while (menu != 0);
		view.showMessage("로그아웃되었습니다.");
	}

	private void removeCartItem() {
		
		
	}

	private boolean loginAdmin() {
		String id = view.inputString("id를 입력해주세요. : ");
		String pw = view.inputString("비밀번호를 입력해주세요. : ");
		String code = view.inputString("관리자 코드를 입력해주세요. : ");
		return admin.login(id, pw) && admin.access(code);
	}


	private void resetCart() {
		view.displayCart(mCart);
		if (!mCart.isEmpty()) {
			view.askConfirm(">> 장바구니를 비우려면 yes를 입력하세요");
			mCart.resetCart();
			view.showMessage(">> 장바구니를 비웠습니다.");
		}

	}

	private void addBook2Cart() {
		view.displayBookInfo(mBookStorage);
		int bookID = view.selectBookId(mBookStorage);
		mCart.addItem(mBookStorage.getBookId(bookID));
		view.showMessage(">>장바구니에 도서를 추가하였습니다.  ");
	}

	private void viewCart() {
		view.displayCart(mCart);
	}

	private void viewBookInfo() {
		view.displayBookInfo(mBookStorage);
	}

}
