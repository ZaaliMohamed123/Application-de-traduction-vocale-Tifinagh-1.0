package beans;

public class Audio {
	private int AudioId;
	private String audioName;
	private String audioLanguage;
    private int audioSizeInKb;
    private String audioExtension;
    private byte[] audioContent; // Representing audio content as byte array

    // Constructors
    public Audio() {
    }

    public Audio(int AudioId , String audioName, int audioSizeInKb, String audioExtension, byte[] audioContent) {
        this.AudioId = AudioId;
    	this.audioName = audioName;
        this.audioLanguage = "Tif";
        this.audioSizeInKb = audioSizeInKb;
        this.audioExtension = audioExtension;
        this.audioContent = audioContent;
    }
    

    
    public Audio(int AudioId ,String audioName, String audioLanguage, int audioSizeInKb, String audioExtension,
			byte[] audioContent) {
		super();
		this.AudioId = AudioId;
		this.audioName = audioName;
		this.audioLanguage = audioLanguage;
		this.audioSizeInKb = audioSizeInKb;
		this.audioExtension = audioExtension;
		this.audioContent = audioContent;
	}
    
    

	public int getAudioId() {
		return AudioId;
	}

	public void setAudioId(int audioId) {
		AudioId = audioId;
	}

	public String getAudioLanguage() {
		return audioLanguage;
	}

	public void setAudioLanguage(String audioLanguage) {
		this.audioLanguage = audioLanguage;
	}

	public String getAudioName() {
        return audioName;
    }

    public void setAudioName(String audioName) {
        this.audioName = audioName;
    }

    public int getAudioSizeInKb() {
        return audioSizeInKb;
    }

    public void setAudioSizeInKb(int audioSizeInKb) {
        this.audioSizeInKb = audioSizeInKb;
    }

    public String getAudioExtension() {
        return audioExtension;
    }

    public void setAudioExtension(String audioExtension) {
        this.audioExtension = audioExtension;
    }

    public byte[] getAudioContent() {
        return audioContent;
    }

    public void setAudioContent(byte[] audioContent) {
        this.audioContent = audioContent;
    }

	@Override
	public String toString() {
		return "Audio [audioId="+ AudioId +", audioName=" + audioName + ", audioLanguage=" + audioLanguage + ", audioSizeInKb=" + audioSizeInKb
				+ ", audioExtension=" + audioExtension + "]";
	}
}
