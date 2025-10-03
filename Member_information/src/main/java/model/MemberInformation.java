package model;

/**
 * 会員情報クラス
 */
public class MemberInformation {

	private String userid; // ユーザーID
	private String username; // ユーザー名
	private String usermail; // メールアドレス
	private String usertel; // 電話番号
	private String useraddress; // 住所
	private String userbirthday; // 生年月日
	private String userjob; //職業
	private String userpassword; //パスワード
	private String user_created_datetime; //登録日
	private String user_updated_datetime; //更新日

	/**
	 * コンストラクタ
	 * @param username
	 * @param usermail
	 * @param usertel
	 * @param useraddress
	 * @param userbirthday
	 * @param userjob
	 * @param userpassword
	 */
	public MemberInformation(String username, String usermail,
			String usertel, String useraddress,
			String userbirthday, String userjob, String userpassword) {
		this.username = username;
		this.usermail = usermail;
		this.usertel = usertel;
		this.useraddress = useraddress;
		this.userbirthday = userbirthday;
		this.userjob = userjob;
		this.userpassword = userpassword;
	}
	
	public MemberInformation(String userid, String username, String usermail,
			String usertel, String useraddress,
			String userbirthday, String userjob, String userpassword) {
		this.userid = userid;
		this.username = username;
		this.usermail = usermail;
		this.usertel = usertel;
		this.useraddress = useraddress;
		this.userbirthday = userbirthday;
		this.userjob = userjob;
		this.userpassword = userpassword;
	}
	
	public MemberInformation(String userid, String username, String usermail,
			String usertel, String useraddress,
			String userbirthday, String userjob, String userpassword, String user_created_datetime, String user_updated_datetime) {
		this.userid = userid;
		this.username = username;
		this.usermail = usermail;
		this.usertel = usertel;
		this.useraddress = useraddress;
		this.userbirthday = userbirthday;
		this.userjob = userjob;
		this.userpassword = userpassword;
		this.user_created_datetime = user_created_datetime;
		this.user_updated_datetime = user_updated_datetime;
	}

	/**
	 * ユーザーIDを返却
	 * @return userid
	 */
	public String getUserId() {
		return userid;
	}

	/**
	 * ユーザーIDをセット
	 * @param userid
	 */
	public void setUserId(String userid) {
		this.userid = userid;
	}
	
	/**
	 * ユーザー名を返却
	 * @return username
	 */
	public String getUserName() {
		return username;
	}

	/**
	 * ユーザー名をセット
	 * @param username
	 */
	public void setUserName(String username) {
		this.username = username;
	}

	/**
	 * メールアドレスを返却
	 * @return usermail
	 */
	public String getUserMail() {
		return usermail;
	}

	/**
	 * メールアドレスをセット
	 * @param usermail
	 */
	public void setUserMail(String usermail) {
		this.usermail = usermail;
	}

	/**
	 * 電話番号を返却
	 * @return usertel
	 */
	public String getUserTel() {
		return usertel;
	}

	/**
	 * 電話番号をセット
	 * @param usertel
	 */
	public void setUserTel(String usertel) {
		this.usertel = usertel;
	}

	/**
	 * 住所を返却
	 * @return useraddress
	 */
	public String getUserAddress() {
		return useraddress;
	}
	
	/**
	 * 住所をセット
	 * @param useraddress
	 */
	public void setUserAddress(String useraddress) {
		this.useraddress = useraddress;
	}

	/**
	 * 生年月日を返却
	 * @return userbirthday
	 */
	public String getUserBirthday() {
		return userbirthday;
	}
	
	/**
	 * 生年月日をセット
	 * @param userbirthday
	 */
	public void setUserBirthday(String userbirthday) {
		this.userbirthday = userbirthday;
	}

	/**
	 * 職業を返却
	 * @return userjob
	 */
	public String getUserJob() {
		return userjob;
	}

	/**
	 * 職業をセット
	 * @param userjob
	 */
	public void setUserJob(String userjob) {
		this.userjob = userjob;
	}

	/**
	 * パスワードを返却
	 * @return userpassword
	 */
	public String getUserPassword() {
		return userpassword;
	}

	/**
	 * パスワードをセット
	 * @param userpassword
	 */
	public void setUserPassword(String userpassword) {
		this.userpassword = userpassword;
	}
	
	/**
	 * 登録日を返却
	 * @return user_created_datetime
	 */
	public String getUser_Created_Datetime() {
		return user_created_datetime;
	}

	/**
	 * 登録日をセット
	 * @param user_created_datetime
	 */
	public void setUser_Created_Datetime(String user_created_datetime) {
		this.user_created_datetime = user_created_datetime;
	}
	
	/**
	 * 更新日を返却
	 * @return user_updated_datetime
	 */
	public String getUser_Updated_Datetime() {
		return user_updated_datetime;
	}

	/**
	 * 更新日をセット
	 * @param user_updated_datetime
	 */
	public void setUser_pdated_Datetime(String user_updated_datetime) {
		this.user_updated_datetime = user_updated_datetime;
	}

}