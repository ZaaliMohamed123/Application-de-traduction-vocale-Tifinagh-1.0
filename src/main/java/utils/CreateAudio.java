package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;



import beans.Audio;
import dao.AudioDao;
import dao.AudioDaoImpl;

public class CreateAudio {
	
	public static void main(String[] args) {
		/*
		AudioDao adao = new AudioDaoImpl();
		Path dir1 = Paths.get("Audios/AudioAr");
		Path dir2 = Paths.get("Audios/AudioFr");
		Path dir3 = Paths.get("Audios/AudioAng");
		
		
		try {
			Stream<Path> list1 = Files.list(dir1);
			Stream<Path> list2 = Files.list(dir2);
			Stream<Path> list3 = Files.list(dir3);
			List<Path> pathList1 = list1.collect(Collectors.toList());
			List<Path> pathList2 = list2.collect(Collectors.toList());
			List<Path> pathList3 = list3.collect(Collectors.toList());
			
			pathList1.sort((p1, p2) -> {
                int num1 = Integer.parseInt(extractAudioNumber(p1.getFileName().toString()));
                int num2 = Integer.parseInt(extractAudioNumber(p2.getFileName().toString()));
                return Integer.compare(num1, num2);
            });
			pathList2.sort((p1, p2) -> {
                int num1 = Integer.parseInt(extractAudioNumber(p1.getFileName().toString()));
                int num2 = Integer.parseInt(extractAudioNumber(p2.getFileName().toString()));
                return Integer.compare(num1, num2);
            });
			pathList3.sort((p1, p2) -> {
                int num1 = Integer.parseInt(extractAudioNumber(p1.getFileName().toString()));
                int num2 = Integer.parseInt(extractAudioNumber(p2.getFileName().toString()));
                return Integer.compare(num1, num2);
            });
			
		
			for (int i = 0; i < pathList1.size(); i++) {
				Audio audioAr = createAudio(pathList1.get(i).toString());
				Audio audioFr = createAudio(pathList2.get(i).toString());
				Audio audioAng = createAudio(pathList3.get(i).toString());
				
				int AudioTifinaghId = Integer.parseInt(extractAudioNumber(audioAr.getAudioName()));
				adao.insertTranslatedAudio(audioAr, AudioTifinaghId);
				adao.insertTranslatedAudio(audioFr, AudioTifinaghId);
				adao.insertTranslatedAudio(audioAng, AudioTifinaghId);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
	}

    public static Audio createAudio(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        String audioName = path.getFileName().toString();
        String audioExtension = getFileExtension(audioName);
        String audioLanguage= extractAudioLanguage(audioName);
        audioName = audioName.replace(audioLanguage+"."+audioExtension, "");
        long audioSizeInBytes = Files.size(path);
        int audioSizeInKb = (int) (audioSizeInBytes / 1024);
        byte[] audioContent = Files.readAllBytes(path);
        int AudioTifinaghId = Integer.parseInt(extractAudioNumber(audioName));

        return new Audio(0, audioName,audioLanguage, audioSizeInKb, audioExtension, audioContent);
    }
    
    public static void insertAudios(String AudiosPath) {
    	
    }
    

    public static String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex == -1) {
            return ""; // No extension found
        }
        return fileName.substring(dotIndex + 1);
    }
    
    public static String extractAudioNumber(String audioName) {
        if (audioName == null || !audioName.startsWith("Audio")) {
            return null; // Invalid format
        }

        // Extract the part after "Audio"
        String remaining = audioName.substring(5);

        // Use regex to separate number and language
        String number = remaining.replaceAll("[^0-9]", "");
   

        // Validate extracted parts
        if (number.isEmpty() ) {
            return null; // Invalid format
        }

        return number;
    }
	
	public static String extractAudioLanguage(String audioName) {
        if (audioName == null || !audioName.startsWith("Audio")) {
            return null; // Invalid format
        }

        // Extract the part after "Audio"
        String remaining = audioName.substring(5);
        String extension = getFileExtension(remaining);
        remaining = remaining.replace("."+extension, "");

        // Use regex to separate number and language
        String language = remaining.replaceAll("[0-9]", "");

        // Validate extracted parts
        if (language.isEmpty()) {
            return null; // Invalid format
        }

        return language;
    }
}

