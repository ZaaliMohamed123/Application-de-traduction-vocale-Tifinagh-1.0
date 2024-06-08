package utils;

import dao.AudioDao;
import dao.AudioDaoImpl;

public class Main {

	public static void main(String[] args) {
		AudioDao adao = new AudioDaoImpl();
		System.out.println(adao.selectTrAudioByAudioTifNameByLanguage("Audio3", "Ang"));

	}

}
