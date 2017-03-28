## 权限控制系统

#### surefire testng测试乱码解决方法
    1. 设置vm options: -Dfile.encoding=UTF-8;
    2. 还有乱码，设置IDEA的idea.exe.vmoptions，添加-Dfile.encoding=UTF-8
    
#### 设置多环境
##### maven profiles
    1.   <profiles>
            <profile>
                <id>dev</id>
                <properties>
                    <profiles.active>dev</profiles.active>
                </properties>
                <activation>
                    <activeByDefault>true</activeByDefault>
                </activation>
            </profile>
            <profile>
                <id>test</id>
                <properties>
                    <profiles.active>test</profiles.active>
                </properties>
            </profile>
            <profile>
                <id>prod</id>
                <properties>
                    <profiles.active>prod</profiles.active>
                </properties>
            </profile>
        </profiles>
        
    2.  <resources>
            <resource>
                <directory>src/main/resources</directory>
                <excludes>
                    <exclude>env/dev/*</exclude>
                    <exclude>env/test/*</exclude>
                    <exclude>env/prod/*</exclude>
                </excludes>
            </resource>
            <resource>
                <directory>src/main/resources/env/${profiles.active}</directory>
            </resource>
        </resources>
        
    3. 项目编译打包，如：mvn clean package -Pprod
    
    -Dspring.profiles.active=dev
这种方式还需动态设置spring对配置文件的引用，不太方便

##### maven profiles filters
    1.  <profiles>
            <profile>
                <id>test</id>
                <activation>
                    <activeByDefault>true</activeByDefault>
                </activation>
                <build>
                    <filters>
                        <filter>src/main/resources/filters/profile-test.properties</filter>
                    </filters>
                </build>
            </profile>
            <profile>
                <id>prod</id>
                <build>
                    <filters>
                        <filter>src/main/resources/filters/profile-production.properties</filter>
                    </filters>
                </build>
            </profile>
        </profiles>
        
    2.  <resources>
            <resource>
                <directory>src/main/resources</directory>
                <filtering>true</filtering>
                <excludes>
                    <exclude>mysql/*</exclude>
                    <exclude>filters/*</exclude>
                </excludes>
            </resource>
        </resources>
        
    3.  项目编译打包，如：mvn clean package -Pproduction