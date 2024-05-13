package bookmarket.view;

import java.util.Scanner;

import bookmarket.model.BookStotage;
import bookmarket.model.Cart;

public class ConsoleView {
	Scanner scanner = new Scanner(System.in);

	public void displayWelcome() {
		System.out.println("*****************************************");
		System.out.println("*    Welcome to Hyejeong Book Market    *");
		System.out.println("*****************************************");
	}

	public int selectMenu(String[] menuList) {
		displayMenu(menuList);
		int menu;
		do {
			System.out.print(">>메뉴 선택 : ");
			menu = scanner.nextInt();
			if (menu < 0 || menu > menuList.length)
				System.out.printf("0부터 %d까지의 숫자를 입력하세요.\n", menuList.length);
		} while (menu < 0 || menu > menuList.length);
		return menu;
	}

	private void displayMenu(String[] menuList) {
		System.out.println("=========================================");
		for (int i = 0; i < menuList.length; i++)
			System.out.println(menuList[i]);
		// System.out.println(menuList[0]);
		System.out.println("=========================================");
	}

	public void displayBookInfo(BookStotage mBookStorage) {
		for (int i = 0; i < mBookStorage.getNumBooks(); i++) {
			String bookInfo = mBookStorage.getBookInfo(i);
			System.out.println(bookInfo);
		}
	}

	public void showMessage(String message) {
		System.out.println(message);

	}

	public void displayCart(Cart mCart) {
		if (mCart.isEmpty()) {
			System.out.printf("장바구니가 비어 있습니다.\n");
			return;
		}
		for (int i = 0; i < mCart.getNumItems(); i++) {
			System.out.println(mCart.getItemInfo(i));
		}

	}

	public boolean askConfirm(String message) {
		System.out.printf("%s", message);
		if (scanner.nextLine().equals("yes"))
			return true;
		return false;
	}

	public int selectBookId(BookStotage bookStorage) {
		int bookId;
		boolean result;
		do {
			System.out.print("추가할 도서의 ID를 입력하세요 : ");
			bookId = scanner.nextInt();
			result = bookStorage.isValidBook(bookId);
			if (!result)
				System.out.print("잘못된 도서의 ID입니다.");
		} while (!result);

		return bookId;
	}

	public String loginplz() {
		System.out.print("아이디와 비밀번호를 입력해주세요.\n아이디 : ");
		String id = scanner.nextLine();
		System.out.print("비밀번호 : ");
		String pw = scanner.nextLine();
		return id + "," + pw;
	}

	public int select() {
		System.out.print("로그인 유형 선택(1. 사용자 | 2. 관리자 | 0. 종료) : ");
		int a = scanner.nextInt();
		scanner.nextLine();
		return a;
	}

	public String inputString(String print) {
		System.out.print(print);
		return scanner.nextLine();
	}
}
