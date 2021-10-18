package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.FitnessDao;

public class UserFire extends JFrame {

	private String id = "";

	public UserFire(String id) {

		this.id = id;
		FitnessDao dao = new FitnessDao();

		int result = JOptionPane.showConfirmDialog(null, "정말 탈퇴 하시겠습니까?", "에러 메세지", JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.YES_OPTION)
			dao.removeMem(id);

	}

}
