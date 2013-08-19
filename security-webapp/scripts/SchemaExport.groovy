import com.wonders.security.entity.*
import org.hibernate.cfg.Configuration
import org.hibernate.tool.hbm2ddl.SchemaExport as SE

def props = new Properties()
props.put("hibernate.dialect", 'org.hibernate.dialect.MySQL5Dialect')

def configuration = new Configuration()
	.addProperties(props)
	.addAnnotatedClass(Organization.class)
	.addAnnotatedClass(Role.class)
	.addAnnotatedClass(Resource.class)
	.addAnnotatedClass(User.class)

new SE(configuration)
	.setDelimiter(";")
	.setFormat(true)
	.setOutputFile("src/main/resources/sql/mysql/schema.sql")
	.create(false, false)