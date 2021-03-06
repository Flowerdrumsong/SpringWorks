package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
		//1. Spring 컨테이너를 구동한다 factory객체가 추상클래스이기 때문에 generic~~클래스를 이용해서 객체를 생성함. 이 객체는 xml 파일을 읽는 역할을 함
		//<bean> 객체를 생성한다. id=객체명(중복불가) 자바의 식별자 명명규칙과 동일
		//구동되자마자 객체들 전부 만들어서 올려놓음 preloading? 방식
		AbstractApplicationContext factory=
				new GenericXmlApplicationContext("annotationContext.xml");
		
		//2. Spring 컨테이너로부터 필요한 객체를 요청(Lookup) 한다.
		TV tv=(TV)factory.getBean("tv");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		//3. Spring 컨테이너를 종료한다.
		factory.close();
		
		//다형성 이용 전
//		SamsungTV tv=new SamsungTV();
//		tv.powerOn();
//		tv.volumeUp();
//		tv.volumeDown();
//		tv.powerOff();
		
//		LgTV tv=new LgTV();
//		tv.powerOn();
//		tv.volumeUp();
//		tv.volumeDown();
//		tv.powerOff();
		
		//다형성 이용 후
//		TV tv=new SamsungTV();
//		tv.powerOn();
//		tv.volumeUp();
//		tv.volumeDown();
//		tv.powerOff();
		
//		TV tv=new LgTV();
		
		//디자인 패턴 이용
//		BeanFactory factory=new BeanFactory();
//		TV tv=(TV) factory.getBean("lg");
//		tv.powerOn();
//		tv.volumeUp();
//		tv.volumeDown();
//		tv.powerOff();
	}
}
