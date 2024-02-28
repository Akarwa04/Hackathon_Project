Overview – Finding Hospital

This project aims to automate the Practo web-based application using Selenium WebDriver. Once the application is launched, we have to click on find doctors and then search doctors for any city and of any expertise and get the list of 5 doctors based on the filters. Then go to Surgeries section and list all the top surgeries present. Navigate to Corporate section and fill Health and Wellness form with different values for contact number and email address.

Plugins and Dependencies

- Maven Compiler Plugin: 3.12.1
- Maven Surefire Plugin: 3.2.5
- Selenium Java: 4.15
- Apache POI & Apache POI OOXML: 5.2.4
- TestNG: 7.8.0
- Log4j: 3.0.0
- Extent Report: 5.1.1
- Selenium WebDriver: 4.10.0
- Cucumber Junit, Cucumber TestNG Cucumber Java: 7.14.1
- Extent Reports Cucumber7 Adapter: 1.14.0

Automation Flow

1. Navigate to Practo application, enter city name and doctor’s speciality in the input boxes.
2. Apply filters such as Number of Patient Stories, Experience, Fees, Availability and Sort the result based on the preference.
3. List first 5 doctors based on the result.
4. Then go to Surgeries section and list all the surgeries mentioned there.
5. Navigate to Health and Wellness Plans under For Corporate dropdown.
6. Fill the Corporate Wellness form with valid and invalid contact numbers and email address.
7. Capture the Thank You message in the end.

