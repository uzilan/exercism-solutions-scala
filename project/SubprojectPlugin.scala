import sbt._

object SubprojectPlugin extends AutoPlugin {
   override val requires = sbt.plugins.JvmPlugin
   override val trigger = allRequirements
   override lazy val extraProjects: Seq[Project] = {
      val dirs = (file(".") * ("*" -- "project" -- "target" -- ".idea" -- ".git")) filter { _.isDirectory }
      dirs.get.toList map { dir =>
         Project(dir.getName.replaceAll("""\W""", "_"), dir)
      }
   }
}