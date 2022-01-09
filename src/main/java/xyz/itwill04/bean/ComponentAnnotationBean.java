package xyz.itwill04.bean;

import org.springframework.stereotype.Component;

// @Component : Ŭ������ Spring Bean���� ����ϱ� ���� ������̼�
//  => �⺻������ Ŭ�������� beanName���� ���� => ù���ڴ� �ҹ��ڷ� �ڵ� ��ȯ
// @Component ������̼��� value �Ӽ��� ����Ͽ� beanName ���浵 �����ϴ�.
//  => �ٸ� �Ӽ��� ���� ��� �Ӽ����� ���� ����
@Component("bean")
public class ComponentAnnotationBean {
	public ComponentAnnotationBean() {
		System.out.println("### ComponentAnnotationBean Ŭ������ �⺻ ������ ȣ�� ###");
	}
	
	public void display() {
		System.out.println("*** ComponentAnnotationBean Ŭ������ display() �޼ҵ� ȣ�� ***");
	}
}
