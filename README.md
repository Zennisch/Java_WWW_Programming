<div>
    <h1>Table of Contents</h1>
    <ul>
        <li><a href="#tutorial-on-creating-a-dynamic-website-project">Tutorial on creating a dynamic website project.</a></li>
        <li><a href="#import-an-eclipse-project-into-intellij-idea">Import an Eclipse project into IntelliJ IDEA.</a></li>
    </ul>
</div>

## Tutorial on creating a dynamic website project

<div>
    <div>
        <h3>Current versions</h3>
        <ul>
            <li>Java Development Kit: 21.0.4</li>
            <li>Apache Tomcat: 10.1.29</li>
            <li>Eclipse IDE: 2024-09</li>
            <li>IntelliJ IDEA: 2024.2.1</li>
        </ul>
    </div>
    <div>
        <h3>Using IntelliJ IDEA</h3>
        <ul>
            <li>Choose Maven Archetype</li>
            <li>Archetype: org.apache.maven.archetypes:maven-archetype-webapp</li>
            <li>Create project</li>
            <li>Add dependencies in pom.xml: jakarta.servlet-api...</li>
            <li>
                Create new run configuration:
                <ul>
                    <li>-> Run configuration dropdown -> Edit configurations</li>
                    <li>-> Plus sign -> Tomcat Server -> Local</li>
                    <li>-> Server/Application server/Configure</li>
                    <li>-> Plus sign -> Choose Tomcat library folder -> OK/OK</li>
                    <li>-> Deployment/Deploy at the server startup</li>
                    <li>-> Plus sign -> Artifact -> Choose war</li>
                    <li>-> Application context -> Change to '/' -> OK</li>
                    <li>-> Run created configuration</li>
                </ul>
            </li>
            <li>Right click main package -> New/Directory/java</li>
            <li>
                Create a servlet:
                <ul>
                    <li>-> New/Java Class</li>
                    <li>-> Extend HttpServlet</li>
                    <li>-> Override methods</li>
                </ul>
            </li>
        </ul>
    </div>
    <div>
        <h3>Using Eclipse</h3>
        <ul>
            <li>Choose Dynamic Web Module Version -> Next -> Next -> Generate web.xml deployment descriptor -> Finish</li>
            <li>Right click project -> Configure -> Convert to Maven Project -> OK</li>
            <li>Add dependencies in pom.xml: jakarta.servlet-api...</li>
            <li>
                Fixing project problems:
                <ul>
                    <li>-> Right click project -> Properties</li>
                    <li>-> Java Build Path -> JRE System Library -> Choose your Java version -> Apply</li>
                    <li>-> Java Compiler -> Choose your Java version -> Apply</li>
                    <li>-> Project Facets -> Java -> Choose your Java version -> Apply</li>
                    <li>-> Web Project Settings -> Context root -> Change to '/' -> Apply</li>
                    <li>-> Apply and Close</li>
                </ul>
            </li>
            <li>
                Create server:
                <ul>
                    <li>-> Servers View -> Click 'No servers are available. Click this link to create a new server...'</li>
                    <li>-> Choose Tomcat 'version' Server -> Next -> Browse</li>
                    <li>-> Choose Tomcat library folder -> Next -> Add your project -> Finish</li>
                </ul>
            </li>
            <li>Right click project -> Run As/Run on Server -> Choose Tomcat 'version' Server -> Next -> Choose project -> Finish</li>
            <li>Create servlet: Right click Java Resources -> New/Servlet -> Finish -> Organize imports (Ctrl+Shift+O)</li>
            <li>Note: Right click server -> Clean... is useful for updating changes</li>
        </ul>
    </div>
</div>

## Import an Eclipse project into IntelliJ IDEA
    
<div>
    <div>
        <ul>
            <li>-> IntelliJ main window -> Open -> Navigate to Eclipse project folder -> OK</li>
            <li>-> Open or Import project -> Open as: Maven project -> OK</li>
        </ul>
    </div>
</div>
