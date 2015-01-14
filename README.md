<h1>Java video blog</h1>

<h2>Development (with embedded HSQL database)</h2>

<p>To run in development mode: <code>mvn jetty:run -P dev -Dspring.profiles.active=dev</code></p>

<h2>Heroku (with PostgreSQL database)</h2>

<p>To deploy on Heroku change in pom.xml: <code>&lt;argument&gt;javavids&lt;/argument&gt;</code> change "javavids" to your application name in Heroku and run: <code>mvn clean install -P prod</code>

<p>How to create Heroku application and install Heroku toolbelt is in this <a href="http://www.javavids.com/video/spring-web-app-tutorial-50-heroku.html" target="_blank">video</a></p>

<p>default username / password: admin / admin</p>
