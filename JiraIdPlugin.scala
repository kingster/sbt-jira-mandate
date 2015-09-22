import sbt._
import Keys._

/**
 * A JIRA ID Mandate Plugin.
 */
object JiraIdPlugin extends AutoPlugin {

  	override def trigger = allRequirements

	object autoImport {
    	val jira = settingKey[String]("jira-project-id")
  	}
  	
  	import autoImport._

  	lazy val settings: Seq[Setting[_]] = Seq(
	    resourceGenerators in Compile += Def.task {

	    	val commitMsgHook =  baseDirectory.value / ".git" / "hooks" / "commit-msg" 
    	 	val contents =
		    	 	"""test "" != "$(grep -E '(""" + jira.value + """)-\d+( |:)\w*' "$1")" || { """ + scala.compat.Platform.EOL + 
					s"echo >&2 'ERROR: Commit message is missing Jira Issue Number in Following Format: <project-ticketid:>, eg: ${jira.value}-142:commit message'  " + scala.compat.Platform.EOL +
					"exit 1  " +  scala.compat.Platform.EOL +
					"}" + scala.compat.Platform.EOL

    		IO.write(commitMsgHook, contents)
	      	commitMsgHook.setExecutable(true);

	      	println(s"[JiraIdPlugin] Commit Message Hook set to Project-Id " +  scala.Console.GREEN +    jira.value  + scala.Console.RESET)
	      
	      	Seq[File]()
	    }.taskValue
  	)


}