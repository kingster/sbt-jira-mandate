import bintray.Keys._

seq(bintrayPublishSettings: _*)

sbtPlugin := true

organization := "com.flipkart.jira"

name := "sbt-jira-mandate"

version := "1.0.1"

description := "Jira Mandate as GIT Commit Hook"

scalaVersion := "2.10.4"

scalacOptions ++= Seq("-deprecation", "-feature")

resolvers += Resolver.sonatypeRepo("snapshots")

publishMavenStyle := false

licenses += ("MIT License", url("https://opensource.org/licenses/MIT"))

repository in bintray := "sbt-plugins"

bintrayOrganization in bintray := None

(vcsUrl in bintray) := Some("git@github.com:kingster/sbt-jira-mandate.git")
