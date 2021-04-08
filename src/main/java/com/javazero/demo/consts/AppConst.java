package com.javazero.demo.consts;

/**
 * Const for Rest
 *
 * @since: 29/03/21.
 * @author: Buituan
 */
public class AppConst {

	public static class RoleConst {
		public final static String ROOT = "ROOT";
		public final static String READ = "READ";
		public final static String WRITE = "WRITE";
	}

	public static class GenderConst {
		public final static int FEMALE = 0; // Nu
		public final static int MALE = 1; // Nam
		public final static int ORTHER = 2; // Khac
	}

	public static class CategoryConst {
		public final static String BLOG_JAVA = "BLOG_JAVA";
		public final static String BLOG_JAVASCRIPT = "BLOG_JAVASCRIPT";
		public final static String BLOG_DEV = "BLOG_DEV";
	}

	public static class PostConst {
		public final static String PUBLIC = "PUBLIC";
		public final static String PRIVATE = "PRIVATE";
		public final static String GROUP = "GROUP";
		
		// remove before
		public final static String BLOG_A ="Cách biểu thị quan hệ n-n trong cơ sở dữ liệu là rất phổ biến, ví dụ một địa chỉ có thể có nhiều người ở (gia đình). và một người có thể có nhiều hơn một địa chỉ.\n" + 
				"\n" + 
				"Bình thường, khi các bạn tạo table trong csdl để biểu thị mối quan hệ này, chúng ta sẽ tạo ra một bảng mới, tham chiếu tới cả bảng này.";
	
		public final static String BLOG_B ="Cách biểu thị quan hệ 1-1 trong cơ sở dữ liệu là rất phổ biến, ví dụ một người sẽ có một địa chỉ duy nhất (giả sử).\n" + 
				"\n" + 
				"Bình thường, khi các bạn tạo table trong csdl để biểu thị mối quan hệ này, thì sẽ có một bảng chứa khóa ngoại của bảng còn lại.";
		public final static String BLOG_C ="Cách biểu thị quan hệ 1-n trong cơ sở dữ liệu là rất phổ biến, ví dụ một địa chỉ có thể có nhiều người ở (gia đình).\n" + 
				"\n" + 
				"Bình thường, khi các bạn tạo table trong csdl để biểu thị mối quan hệ này, thì bảng đại diện phía nhiều (phía n trong câu 1-n) sẽ chứa id của bảng tham chiếu (phía 1 trong câu 1-n)" + 
				"Bình thường, khi các bạn tạo table trong csdl để biểu thị mối quan hệ này, thì sẽ có một bảng chứa khóa ngoại của bảng còn lại.";
		public final static String BLOG_D ="Trong bài hôm nay chúng ta sẽ tìm hiểu một phần cực kỳ quan trọng trong các hệ thống bảo mật ngày nay, đó là JWT.\n" + 
				"\n" + 
				"JWT (Json web Token) là một chuỗi mã hóa được gửi kèm trong Header của client request có tác dụng giúp phía server xác thực request người dùng có hợp lệ hay không. Được sử dụng phổ biến trong các hệ thống API ngày nay.";
		public final static String BLOG_E ="Webpack là một công cụ giúp chúng ta build và quản lý project của mình dưới dạng module.\n" + 
				"\n" + 
				"Khi thực tế cho thấy ở phía frontend ngày càng phình to hơn về các file javascript cũng như nhiều công nghệ mới. Kéo theo đó dẫn tới sự cồng kềnh của một project. Dẫn tới cần có một công cụ giúp chúng ta quản lý và chia module. Lúc cần thì lấy ra sử dụng chứ k xài bừa bãi.";
	}
}
