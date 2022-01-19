# Annuity Credit Calculator
Technologies:
- Spring MVC
- UI - JSP + JSTL
- DB - H2 in memory and Hibernate
- Connection pool / Transaction control with c3p0
- Validation params with Hibernate-validator and custom annotation
- Locale server - Apache Tomcat

This application demonstrates a CRUD operations with Credit in DataBase with Hibernate and Calculation of the loan schedule

Interface in my Application 

- Main Page 
![ScreenShot](./src/main/java/com/antonbelykh/spring/spring_mvc/images/main.png)

- Add and Edit page with validation
![ScreenShot](./src/main/java/com/antonbelykh/spring/spring_mvc/images/edit.png)

- After add/edit Credit your need press on button "Calculate Payments" and status is change
![ScreenShot](./src/main/java/com/antonbelykh/spring/spring_mvc/images/calculate.png)

- If you want to see Schedule of Payments your Credit -> press button "Show Payments"
![ScreenShot](./src/main/java/com/antonbelykh/spring/spring_mvc/images/schedule.png)

- Delete Credit with schedule Payments (Hibernate-CascadeAll and Bi-directional). Delete Credit with id=1
![ScreenShot](./src/main/java/com/antonbelykh/spring/spring_mvc/images/delete.png)

- Also added to this project Monitoring Beans in IoC and ling for DB in memory
![ScreenShot](./src/main/java/com/antonbelykh/spring/spring_mvc/images/ioc.png)
![ScreenShot](./src/main/java/com/antonbelykh/spring/spring_mvc/images/db.png)