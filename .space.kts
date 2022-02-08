/**
* JetBrains Space Automation
* This Kotlin-script file lets you automate build activities
* For more info, see https://www.jetbrains.com/help/space/automation.html
*/

/**
 * Remote for space: https://git.jetbrains.space/majek/advancements-api/advancements-api.git
 */

job("Build and run tests with Maven") {
    container(displayName = "Run mvn install", image = "maven:latest") {
        shellScript {
            content = """
	            mvn clean install
            """
        }
    }
}
