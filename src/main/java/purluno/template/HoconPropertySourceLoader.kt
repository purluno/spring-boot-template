package purluno.template

import com.typesafe.config.ConfigFactory
import com.typesafe.config.ConfigParseOptions
import com.typesafe.config.ConfigSyntax
import org.springframework.boot.env.PropertySourceLoader
import org.springframework.core.env.MapPropertySource
import org.springframework.core.env.PropertySource
import org.springframework.core.io.Resource
import java.io.InputStreamReader

class HoconPropertySourceLoader : PropertySourceLoader {

    override fun getFileExtensions(): Array<String> = arrayOf("conf")

    override fun load(name: String, resource: Resource): List<PropertySource<*>> {
        val config = ConfigFactory
            .parseReader(
                InputStreamReader(resource.inputStream, Charsets.UTF_8),
                ConfigParseOptions.defaults().setSyntax(ConfigSyntax.CONF)
            )
            .resolve()
        val configMap = config.entrySet().associate { (k, v) -> k to v.unwrapped() }
        return listOf(MapPropertySource(name, configMap))
    }
}
