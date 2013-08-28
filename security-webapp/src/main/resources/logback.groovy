import ch.qos.logback.classic.Level
import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.ConsoleAppender

def stream = this.class.getResourceAsStream('application.properties'),
	props = new Properties()
	
props.load(stream)

def level = (props['log.level'] as String).toUpperCase()

appender('CONSOLE', ConsoleAppender) {
	encoder(PatternLayoutEncoder) { pattern = '%d{HH:mm:ss} %msg%n' }
}
root(new Level(Level."${level + '_INT'}", level), ['CONSOLE'])