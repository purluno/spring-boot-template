package purluno.template

import com.typesafe.config.Config
import org.springframework.core.env.EnumerablePropertySource

class TypesafeConfigPropertySource(name: String, config: Config) : EnumerablePropertySource<Config>(name, config) {

    private val configMap = config.entrySet().associate { (k, v) -> k to v.unwrapped() }

    private val propertyNames = configMap.keys.toTypedArray()

    override fun getPropertyNames(): Array<String> {
        return propertyNames
    }

    override fun getProperty(name: String?): Any? {
        if (name == null) {
            return null
        } else {
            return configMap[name]
        }
    }
}
