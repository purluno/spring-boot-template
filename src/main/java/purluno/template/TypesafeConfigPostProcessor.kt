package purluno.template

import com.typesafe.config.ConfigFactory
import org.apache.logging.log4j.LogManager
import org.springframework.boot.SpringApplication
import org.springframework.boot.env.EnvironmentPostProcessor
import org.springframework.core.env.ConfigurableEnvironment

class TypesafeConfigPostProcessor : EnvironmentPostProcessor {

    companion object {
        val logger = LogManager.getLogger(TypesafeConfigPostProcessor::class.java)
    }

    override fun postProcessEnvironment(environment: ConfigurableEnvironment, application: SpringApplication) {
        val source = TypesafeConfigPropertySource("typesafe-config", ConfigFactory.load())
        environment.propertySources.addLast(source)
    }
}
