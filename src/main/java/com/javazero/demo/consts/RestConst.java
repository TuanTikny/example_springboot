package com.javazero.demo.consts;

/**
 * Const for Rest
 *
 * @since: 29/03/21.
 * @author: Buituan
 */
public class RestConst {
	public static class ErrorCode {

		public final static String UNKNOWN = "000";
		public final static String VALIDATE_FAIL = "001";
		public final static String EMPTY_PARAM = "002";
		public final static String DATABASE_ERROR = "003"; 

	}

	public static class HttpCode {
		public final static String Continue = "100";
		public final static String SwitchingProtocols = "101";
		public final static String Processing = "102";

		public final static String OK = "200";
		public final static String Created = "201";
		public final static String Accepted = "202";

	}
}
