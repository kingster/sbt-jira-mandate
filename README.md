# sbt-jira-mandate

An [sbt](http://www.scala-sbt.org/) (Simple Build Tool) plugin for generating [Git Hooks](http://git-scm.com/docs/githooks) to force mandate JIRA-ID in commit's.

## Add Plugin

To add sbt-jira-mandate functionality to your project add the following to your `project/plugins.sbt` file:

```scala
resolvers += Resolver.url("kinshuk-bintray", url("https://dl.bintray.com/kingster/sbt-plugins"))(Resolver.ivyStylePatterns)

addSbtPlugin("com.flipkart.jira" % "sbt-jira-mandate" % "1.0.2")
```

If you want to use it for more than one project, you can add it to your global plugins file, usually found at: `~/.sbt/plugins/plugins.sbt` and then have it available for all sbt projects. See [Using Plugins](http://www.scala-sbt.org/release/docs/Getting-Started/Using-Plugins.html) for additional information on sbt plugins.

## Enabling Plugin

On your project root add the following to your `built.sbt` file :

```scala
import JiraIdPlugin.autoImport._

jira := "BRO"
seq(JiraIdPlugin.settings: _*)
```

### Requirements

* sbt 0.13.5+ (requires `AutoPlugin`)
* Scala 2.10.x

## Committing Changes

```bash
git commit -m "BRO-XX <commit message>"
git commit -m "BRO-XX: <commit message>"
```