package exception;

/**
 * このシステム内で発生した例外を示すクラス
 */
public class MembershipException extends Exception {
	/**
	 * @param message 発生内容を示すメッセージ
	 */
	public MembershipException(String message) {
		super(message);
	}
}