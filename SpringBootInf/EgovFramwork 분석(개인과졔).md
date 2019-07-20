## Core 분석(개인과제)

### extends Egov 분석

- EgovAbstracServiceImpl

- EgovAbstractmapper

- EgovAbstractdao 





### Core(xml) 분석

- context-aspect.xml

  - Spring에서의 AOP 프로그래밍을 사용하기 위한 Core
  - 용어 정리
    - Aspect
    - Join point
    - Pointcut
    - Advice
    - Proxy
    - Target
  - 코드

  	<aop:config>
  		// user.service.impl 패키지 이하, impl로 끝나는 패키지의 클래스 명이 impl로 끝나는 클래스의 모든 메서드가 대상이 된다(CommonServiceimpl.java)
  		<aop:pointcut id="serviceMethod" expression="execution(* user.service.impl.*Impl.*(..))" />
  		// exceprion이 발생하면 exceprionTransfer에게 알려줘 특정 예외처리를 한다
  		<aop:aspect ref="exceptionTransfer">
  			<aop:after-throwing throwing="exception" pointcut-ref="serviceMethod" method="transfer" />
  		</aop:aspect>
  	</aop:config>
  	
  	// exceprionTransfer은 정의한 2가지 default, other ExceprionGandleManager에게 해당 예외발생을 알림
  	<bean id="exceptionTransfer" class="egovframework.rte.fdl.cmmn.aspect.ExceptionTransfer">
  		<property name="exceptionHandlerService">
  			<list>
  				<ref bean="defaultExceptionHandleManager" />
  				<ref bean="otherExceptionHandleManager" />
  			</list>
  		</property>
  	</bean>
  	
  	// 밑에 2가지 handelr들은 특정 패턴(Patten)에 맞는 경우에만 반응하도록 해둔 것
  	여기서는 service.impl이하 패키지에 속한 클래스에서 오류가 발생한 경우에 자신의 handler를 수행하게 되어있다.
  	<bean id="defaultExceptionHandleManager" class="egovframework.rte.fdl.cmmn.exception.manager.DefaultExceptionHandleManager">
  		<property name="reqExpMatcher">
  			<ref bean="antPathMater"/>
  		</property>
  		<property name="patterns">
  			<list>
  				<value>**service.impl.*</value>
  			</list>
  		</property>
  		<property name="handlers">
  			<list>
  				<ref bean="egovHandler" />
  			</list>
  		</property>
  	</bean>
  	
  	<bean id="otherExceptionHandleManager" class="egovframework.rte.fdl.cmmn.exception.manager.DefaultExceptionHandleManager">
  		<property name="reqExpMatcher">
  			<ref bean="antPathMater"/>
  		</property>
  		<property name="patterns">
  			<list>
  				<value>**service.impl.*</value>
  			</list>
  		</property>
  		<property name="handlers">
  			<list>
  				<ref bean="otherHandler" />
  			</list>
  		</property>
  	</bean>
  	
  	<bean id="egovHandler" class="egovframework.example.cmmn.EgovSampleExcepHndlr" />
  	<bean id="otherHandler" class="egovframework.example.cmmn.EgovSampleOthersExcepHndlr" />	

  </beans>

- context-common.xml

  - 공통되거나 일반적인 설정

  - 다국어 처리 or 개별 trace 처리 설정 파일

  - 코드

        // annotation이 설정된 클래스들을 메모리상에 올리는데, Controller타입의 annotation 제외
        <context:component-scan base-package="user">
           <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller" />
        </context:component-scan>
        
        <bean id="messageSource" class="org.springframework.context.support.ReloadableResourceBundleMessageSource">
        	<property name="basenames">
        		<list>
        			<value>classpath:/egovframework/message/message-common</value>
        			<value>classpath:/egovframework/rte/fdl/idgnr/messages/idgnr</value>
        			<value>classpath:/egovframework/rte/fdl/property/messages/properties</value>
        		</list>
        	</property>
        	<property name="cacheSeconds">
        		<value>60</value>
        	</property>
        </bean>
        
        <bean id="leaveaTrace" class="egovframework.rte.fdl.cmmn.trace.LeaveaTrace">
        	<property name="traceHandlerServices">
        		<list>
        			<ref bean="traceHandlerService" />
        		</list>
        	</property>
        </bean>
        
        <bean id="traceHandlerService" class="egovframework.rte.fdl.cmmn.trace.manager.DefaultTraceHandleManager">
        	<property name="reqExpMatcher">
        		<ref bean="antPathMater" />
        	</property>
        	<property name="patterns">
        		<list>
        			<value>*</value>
        		</list>
        	</property>
        	<property name="handlers">
        		<list>
        			<ref bean="defaultTraceHandler" />
        		</list>
        	</property>
        </bean>
        
        <bean id="antPathMater" class="org.springframework.util.AntPathMatcher" />
        <bean id="defaultTraceHandler" class="egovframework.rte.fdl.cmmn.trace.handler.DefaultTraceHandler" />

- context-datasource.xml

  - DB접속 설정관련 datasource 설정

  - 코드

        // 밑에 정의된 DB를 사용할 수 있다
        <bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close">	
        	// value : driverClassName 입력
            <property name="driverClassName" value="core.log.jdbc.driver.OracleDriver"/>
            // value : 주소입력
            <property name="url" value="jdbc:oracle:thin:@study.xrp.kr:1522:orcl" />
            // value : 아이디 입력
            <property name="username" value="android"/>
            // value : 비밀번호 입력
            <property name="password" value="tmxjel"/>
        </bean>

- context-mapper.xml

  - DB쿼리 이후 VO(Value Object)객체에 대한 Mapping을
    IBatis or MyBatis등을 사용해서 할수 있도록 설정

  - 코드

    	<bean id="sqlSession" class="org.mybatis.spring.SqlSessionFactoryBean">
      		// name : sqlSession 빈에서 사용할 이름
      		// ref : context-datasource.xml에서 정의한 빈의 참조 의미
      		<property name="dataSource" ref="dataSource" />
      		<property name="configLocation" value="classpath:/egovframework/sqlmap/example/sql-mapper-config.xml" />
      		//우리가 작성할 SQL문이 위치할 장소 의미
      		<property name="mapperLocations" value="classpath:/egovframework/sqlmap/example/mappers/*.xml" />
      	</bean>

- context-properties.xml

  - 각종 설정값 설정

  - 보통 자주 사용하는 pageSIze or PazeUnit 등을 여기서 설정하여 key값을 호출한다

  - 코드

    	// name : 빈의 이름 명시
      	<bean name="propertiesService" class="egovframework.rte.fdl.property.impl.EgovPropertyServiceImpl" destroy-method="destroy">
      		<property name="properties">
      	        <map>
      	        	// key, vlaue 값 설정
      	        	<entry key="pageUnit" value="10"/>
      	        	<entry key="pageSize" value="10"/>
      	        </map>
      		</property>
      	</bean>

- context-transaction.xml

  - 트렌젝션 설정

  - 여기서는 Service.imple에서 발생하는 이벤트에 대한 Transaction 처리

  - 코드

    	// id : 빈 id 명시
      	<bean id="txManager" 
      	//dataSource라는 id의 bean을 매개변수로 사용
      	// dataSource에서 발생하는 Transaction에 대한 처리를 하겠다는 의미를 가진다
      	class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
      		<property name="dataSource" ref="dataSource"/>
      	</bean>
      	
      	// <tx:advice> 태그를 이용하여 advice정의
      	// 이 advice가 언제 실행될지 <aop:config> 태그를 사용하여 pointcut과 매핑
      	<tx:advice id="txAdvice" transaction-manager="txManager">
      		<tx:attributes>
      			<tx:method name="*" rollback-for="Exception"/>
      		</tx:attributes>
      	</tx:advice>
      	
      	<aop:config>
      		// user.service.impl경로의 모든 impl에서 Exceprion이 발생하면 위에 advice에서 정의한 rollback을 하겠다는 선언
      		<aop:pointcut id="requiredTx" expression="execution(* user.service.impl.*Impl.*(..))"/>
      		<aop:advisor advice-ref="txAdvice" pointcut-ref="requiredTx" />
      	</aop:config>

- context-validator.xml

  - 검증관련(회원가입 할때, id 길이, mail주소 포함여부 등) 설정

  - 코드

        <bean id="beanValidator" class="org.springmodules.validation.commons.DefaultBeanValidator">
            <property name="validatorFactory" ref="validatorFactory"/>
        </bean>
        
        <bean id="validatorFactory" class="org.springmodules.validation.commons.DefaultValidatorFactory">
            <property name="validationConfigLocations">
                <list>
                    <value>/WEB-INF/config/egovframework/validator/validator-rules.xml</value>
                    <value>/WEB-INF/config/egovframework/validator/validator.xml</value>
                </list>
            </property>
        </bean>





### 연습용 Controller

Controller -> Service -> DAO(DB)





### JavaScrypt로 번호 추출 Code