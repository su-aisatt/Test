package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.MembershipException;
import model.MemberInformation;

/**
 * 会員情報関連のDAOクラス
 */
public class MemberDao extends BaseDao {
	/**
	 * DB接続
	 * @throws MembershipException
	 */
	public MemberDao() throws MembershipException {
		super();
	}

	/**
	 * 会員情報テーブルに登録されているすべての会員情報を検索
	 * 検索結果が0件の場合は空のリストを返却
	 * @return 会員情報リスト
	 * @throws MembershipException
	 **/
	public List<MemberInformation> findAllMember() throws MembershipException {
		// 会員情報リスト
		ArrayList<MemberInformation> memberList = new ArrayList<>();
		try {
			// SQL文
			// 全会員情報を検索
			String sql = "SELECT * FROM user_info";

			// SQL実行
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			// 検索結果から会員情報の各項目を取得してリストに格納
			// レコード数分(人数分)ループ
			while (rs.next()) {

				String userid = rs.getString("user_id");
				String username = rs.getString("user_name");
				String usermail = rs.getString("mail");
				String usertel = rs.getString("tel");
				String useraddress = rs.getString("address");
				String userbirthday = rs.getString("birthday");
				String userjob = rs.getString("job");
				String userpassword = rs.getString("password");
				String user_created_datetime = rs.getString("created_datetime");
				String user_updated_datetime = rs.getString("updated_datetime");

				MemberInformation member = new MemberInformation(userid, username, usermail,
						usertel, useraddress, userbirthday, userjob,
						userpassword, user_created_datetime, user_updated_datetime);

				// 1人分の会員情報をリストに追加
				memberList.add(member);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MembershipException("会員情報の取得に失敗しました");
		}

		// 会員情報リストを返却
		return memberList;
	}

	/**
	 * 指定された会員情報をDBに新規登録
	 * @param memberinfo 会員情報
	 * @throws MembershipException
	 */
	public void insertMember(MemberInformation memberinfo) throws MembershipException {
		// DBに登録する会員情報を取得
		String username = memberinfo.getUserName(); // ユーザー名
		String usermail = memberinfo.getUserMail(); // メールアドレス
		String usertel = memberinfo.getUserTel(); // 電話番号
		String useraddress = memberinfo.getUserAddress(); //住所
		String userbirthday = memberinfo.getUserBirthday(); //生年月日
		String userjob = memberinfo.getUserJob(); //職業
		String userpassword = memberinfo.getUserPassword(); //パスワード

		try {
			// SQL文
			// 会員情報テーブルへの追加
			String sql = "INSERT INTO user_info(user_name, mail,"
					+ "tel, address, birthday,"
					+ "job, password)"
					+ "VALUE(?, ?, ?, ?, ?, ?, ?)";

			// SQL実行
			ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, usermail);
			ps.setString(3, usertel);
			ps.setString(4, useraddress);
			ps.setString(5, userbirthday);
			ps.setString(6, userjob);
			ps.setString(7, userpassword);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new MembershipException("会員情報の登録に失敗しました");
		}
	}

	public List<MemberInformation> findMember(String user_id, String user_name) throws MembershipException {
		// 会員情報リスト
		ArrayList<MemberInformation> memberList = new ArrayList<>();

		try {
			// SQL文
			// ユーザーIDとユーザー名をもとに検索
			String sql = "SELECT * FROM user_info WHERE user_id=? OR user_name=?";

			// SQL実行
			ps = con.prepareStatement(sql);
			ps.setString(1, user_id);
			ps.setString(2, user_name);
			rs = ps.executeQuery();

			// 検索結果から会員情報の各項目を取得してリストに格納
			while (rs.next()) {

				String userid = rs.getString("user_id");
				String username = rs.getString("user_name");
				String usermail = rs.getString("mail");
				String usertel = rs.getString("tel");
				String useraddress = rs.getString("address");
				String userbirthday = rs.getString("birthday");
				String userjob = rs.getString("job");
				String userpassword = rs.getString("password");
				String user_created_datetime = rs.getString("created_datetime");
				String user_updated_datetime = rs.getString("updated_datetime");

				MemberInformation member = new MemberInformation(userid, username, usermail,
						usertel, useraddress, userbirthday, userjob,
						userpassword, user_created_datetime, user_updated_datetime);
				memberList.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MembershipException("会員情報の取得に失敗しました");
		}

		return memberList;

	}

	public void editMember(MemberInformation memberinfo) throws MembershipException {

		String userid = memberinfo.getUserId(); //ユーザーID
		String username = memberinfo.getUserName(); // ユーザー名
		String usermail = memberinfo.getUserMail(); // メールアドレス
		String usertel = memberinfo.getUserTel(); // 電話番号
		String useraddress = memberinfo.getUserAddress(); //住所
		String userbirthday = memberinfo.getUserBirthday(); //生年月日
		String userjob = memberinfo.getUserJob(); //職業
		String userpassword = memberinfo.getUserPassword(); //パスワード

		try {

			// SQL文
			//対象レコードの情報を更新
			String sql = "UPDATE user_info "
					+ "SET user_name=?, mail=?, tel=?, "
					+ "address=?, birthday=?, job=?, "
					+ "password=? WHERE user_id=?";

			// SQL実行
			ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, usermail);
			ps.setString(3, usertel);
			ps.setString(4, useraddress);
			ps.setString(5, userbirthday);
			ps.setString(6, userjob);
			ps.setString(7, userpassword);
			ps.setString(8, userid);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new MembershipException("会員情報の更新に失敗しました");
		}
	}

	public void deleteMember(String user_id) throws MembershipException {

		try {
			// SQL文
			// 対象レコードを削除
			String sql = "DELETE FROM user_info "
					+ "WHERE user_id=?";

			// SQL実行
			ps = con.prepareStatement(sql);
			ps.setString(1, user_id);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new MembershipException("会員情報の削除に失敗しました");
		}

	}

}