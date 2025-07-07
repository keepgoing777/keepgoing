# Web Server와 WAS

## 웹 서버(Web Server)

- 웹에서 서버 기능을 수행하는 프로그램
- HTML문서나 JPG, PNG 같은 이미지를 HTTP 프로토콜을 통해 웹 브라우저에 제공하는 서버
- 서버 내부의 이미 만들어져 있는 정적인 요소들을 화면에 제공하는 역할
- Apache : Apache Software Foundation에서 만든 웹 서버로 HTTP 통신에 대한 여러 라이브러리 제공

## 웹 애플리케이션 서버(WAS, Web Application Server)

- 웹 서버가 할 수 없는 다양한 비지니스 로직을 수행하고 동적인 페이지를 만들어 제공하는 서버
- 웹 애플리케이션 서버는 웹 서버와 컨테이너로 구성
- Tomcat : Apache Software Foundation에서 Servlet과 JSP를 통한 동적인 웹 문서를 처리하기 위해 만들어진 WAS

# 서블릿(Sevlet)

- 웹 서비스를 위한 자바 클래스를 말하며 자바를 사용해서 웹을 만들기 위한 기술
- 웹 브라우저로부터 요청을 받아 처리하고 결과를 다시 웹 브라우저로 응답하는 역할

## 동작구조

1. 클라이언트가 웹 브라우저를 통해 요청을 보낸다.
2. 해당 요청이 서블릿에 대한 요청이면 컨테이너에게 처리를 넘긴다.
3. 서블릿에서 요청에 대한 실행이 완료된 후에는 컨테이너가 실행 결과를 웹 서버에 전달한다.
4. 웹 서버는 서비스를 요청한 클라이언트에 응답한다.
5. 컨테이너의 서블릿에 대한 설정은 배포 서술자(web.xml)에 작성한다.

## 배포 서술자(Deployment Descriptor)

- 애플리케이션에 대한 전체 설정 정보를 가지고 있는 파일
- 배포 서술자의 정보를 가지고 컨테이너가 서블릿 구동한다.
- 웹 애플리케이션 폴더의 WEB-INF 폴더에 web.xml 파일이 배포 서술자다.

## 서블릿 매핑

- 클라이언트의 요청을 서블릿에게 전달하기 위해서 서블릿을 등록하고 매핑해야 한다.
- 서블릿을 등록하고 매핑하는 방법은 web.xml과 @annotaion을 이용하는 방법이 있다.

```xml
<servlet>
  <servlet-name>서블릿 이름</servlet-name>
  <servlet-class>서블릿 클래스</servlet-class>
</servlet>
<servlet-mapping>
  <servlet-name>서블릿 이름</servlet-name>
  <url-pattern>접근 URL 패턴</url-pattern>
</servlet-mapping>
```

```java
@WebServlet("접근 URL 패턴")
public class 서블릿이름 extends HttpServlet{

}
```
