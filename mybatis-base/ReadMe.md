1. mapper.xml 和mapper.java 必须是同包, 那么在resource下面也要同胞
2. maven 构建的 项目classpath的 目录为resource，所以有时候会找不到 在src 里面 .xml
3. 如果更改/添加 classpath 目录参考， pom.xml
	<finalName>mybatis-demo</finalName>
	<sourceDirectory>src/main/java</sourceDirectory>
	<testSourceDirectory>src/test/java</testSourceDirectory>
	<resources>
		<resource>
			<directory>src/main/resources</directory>
		</resource>
		<resource>
			<directory>src/main/java</directory>
		</resource>
	</resources>
	<testResources>
		<testResource>
			<directory>src/test/resources</directory>
		</testResource>
	</testResources>