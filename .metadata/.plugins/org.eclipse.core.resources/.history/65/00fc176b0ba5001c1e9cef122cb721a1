package polymorphism;

public class SamsungTV implements TV {
	private Speaker speaker;
	private int price;
	
	public SamsungTV() {
		System.out.println("===> SamsungTV(1) 객체 생성");
	}
	public SamsungTV(Speaker speaker) {
		System.out.println("===> SamsungTV(2) 객체 생성");
		this.speaker=speaker;
	}
	//<bean id="tv" class="polymorphism.SamsungTV" scope="prototype">
	//	<constructor-arg index="0" ref="apple"></constructor-arg> xml에 이렇게 되어 있으니까
	// Speaker speaker=new AppleSpeaker();
	// Speaker는 인터페이스인데, Speaker를 상속받은 Speaker의 자식인 AppleSpeaker를 통해서 객체를 생성한 것
	public SamsungTV(Speaker speaker, int price) {
		System.out.println("===> Samsung(3) 객체 생성");
		this.speaker=speaker;
		this.price=price;
	}
	
	public void powerOn() {
		System.out.println("SamsungTV -- 전원 켠다. (가격: "+price+")");
	}
	public void powerOff() {
		System.out.println("SamsungTV -- 전원 끈다.");
	}
	public void volumeUp() {
		System.out.println("SamsungTV -- 소리 올린다.");
//		speaker=new SonySpeaker();
		speaker.volumeUp();
	}
	public void volumeDown() {
		System.out.println("SamsungTV -- 소리 내린다.");
//		speaker=new SonySpeaker();
		speaker.volumeDown();
	}

}
