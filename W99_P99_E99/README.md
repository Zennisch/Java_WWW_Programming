### FLOW
- Java - Maven - com.fit.iuh - exam - com.fit.iuh - JDK version - Java version - Jar
- Dependencies:
    - Spring Web
    - Spring Boot DevTools
    - Lombok
    - Rest Repositories
    - Thyemeleaf
    - Spring Data JPA
    - MS SQL Server Driver
    - Validation
- application.properties
    - spring.application.name=exam
    - 
    - server.address=localhost
    - server.port=8080
    - 
    - spring.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver
    - spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=Review;encrypt=false;trustServerCertificate=true;
    - spring.datasource.username=sa
    - spring.datasource.password=sapassword
    - spring.jpa.hibernate.ddl-auto=update
    - spring.jpa.show-sql=true
    - 
    - spring.thymeleaf.prefix=classpath:/templates/
    - spring.thymeleaf.suffix=.html
    - spring.thymeleaf.mode=HTML
    - spring.thymeleaf.cache=true
    - spring.thymeleaf.encoding=UTF-8
- Create entity
    - @Entity
    - @Table(name = "table_name")
    - @Id
    - @GeneratedValue(strategy = GenerationType.IDENTITY)
    - @Column(name = "column_name", nullable = false, unique = true, columnDefinition = "data_type")
    - @ManyToOne(fetch = FetchType.EAGER)
    - @OneToMany(mappedBy = "column_name", fetch = FetchType.EAGER)
    - @OneToOne
    - @JoinColumn(name = "column_name", referencedColumnName = "column_name")
    - @Enumerated(EnumType.STRING)
    - @Getter
    - @Setter
    - @NoArgsConstructor
    - @AllArgsConstructor
    - @EqualsAndHashCode(onlyExplicitlyIncluded = true)
    - @ToString
    - @EqualsAndHashCode.Include
- Create repository
    - @Repository
    - public interface RepositoryName extends JpaRepository<EntityName, DataType>
    - @Query("SELECT e FROM EntityName e WHERE e.column_name = :column_name")
    - List<EntityName> findEntityNameByColumnName(@Param("column_name") DataType column_name);
- Create service
    - @Service
    - public class ServiceName
    - @Autowired
    - private RepositoryName repositoryName;
    - public List<EntityName> getAll()
- Create controller
    - @Controller
    - public class ControllerName
    - @Autowired
    - private ServiceName serviceName;
    - @GetMapping("/path")
    - public String methodName(Model model)
    - model.addAttribute("attribute_name", serviceName.getAll());
    - return "view_name";
- Create view
    - xmlns:th="http://www.thymeleaf.org"
    - ${...}: variable expression
    - *{...}: selection expression
    - #{...}: message expression
    - @{...}: link expression
    - ~{...}: fragment expression
    - th:text="${variable_name}"
    - th:each="variable_name : ${variable_name}"
    - th:if="${variable_name}"
    - th:unless="${variable_name}"
    - th:object="${variable_name}"
    - th:field="*{variable_name}"
    - th:action="@{/path}"
    - th:method="post"
    - th:errors="*{variable_name}"
    