package Prueba1.Prueba2;

import Prueba1.Prueba2.bean.MyBean;
import Prueba1.Prueba2.bean.MyBeanWithDependency;
import Prueba1.Prueba2.component.ComponentDependency;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Prueba2Application implements CommandLineRunner {

	private  ComponentDependency componentDependency;
	private MyBean myBean;

	private MyBeanWithDependency myBeanWithDependency;


	public Prueba2Application(@Qualifier("componentTwoImplement")ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
	}
	public static void main(String[] args) {
		SpringApplication.run(Prueba2Application.class, args);
	}

	@Override
	public void run(String... args){
	componentDependency.saludar();
	myBean.print();
	myBeanWithDependency.printWithDependency();
	}
}
