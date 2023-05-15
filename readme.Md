### Adding Allure dependencies in maven’s pom.xml:

Now let us add the dependencies in the pom.xml file.

Assuming that Selenium and TestNG dependencies are already available in the pom.xml (You can refer to my medium page for adding the selenium and TestNG dependencies if you wish to), let's add Allure dependencies in pom.xml.

Open the pom.xml file in eclipse/ any editor that you are using and add the following dependencies related to the Allure:

### 1. aspectj property:
Add aspectj property under <properties>

`<properties>
  <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  <aspectj.version>1.9.9.1</aspectj.version>
</properties>`

### 2. allure-testng dependency:
Add allure-testng dependency under <dependencies>

`<dependency>
  <groupId>io.qameta.allure</groupId>
  <artifactId>allure-testng</artifactId>
  <version>2.17.3</version>
</dependency>`

### 3. Maven compiler plugin and maven surefire plugin:
Add maven compiler plugin under <plugins>

`<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-compiler-plugin</artifactId>
  <version>3.8.1</version>
</plugin>`

Add maven surefire plugin under <plugins>. Inside maven surefire plugin add java agent argument line under <configuration> and add aspectjweaver dependency under <dependencies>.

`<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-surefire-plugin</artifactId>
  <version>2.22.2</version>
  <configuration>
    <argLine> -javaagent:"${settings.localRepository}/org/aspectj/aspectjweaver/${aspectj.version}/aspectjweaver-${aspectj.version}.jar"
    </argLine>
    <suiteXmlFiles>
      <suiteXmlFile>testng_jenkins.xml</suiteXmlFile>
    </suiteXmlFiles>
  </configuration>
<dependencies>
  <dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjweaver</artifactId>
    <version>${aspectj.version}</version>
  </dependency>
</dependencies>
</plugin>`

### After running the Testcase, to generate the Allure reports run `allure serve allure-results` in command line/terminal.
