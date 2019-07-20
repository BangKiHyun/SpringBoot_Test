## SpringFramework Code 분석

#### Maven Dependencies

- 현재 프로젝트에서 사용할 의존성 주입시켜놓은 것



#### Annotation

- @Controller

  - 해당 클래스를 웹 요청을 처리하는 컨트롤러로 사용

- @Resource(name = "CommonService")
  private CommonService commonService;

  - CommonService로 정의된 bean을 사용하겠다

- @RequestMapping("value="/common/select.do")

  - 컨트롤러가 처리할 요청 URL을 명시하는데 사용
  - url : common/select.do를 사용하면 정의된 메소드가 실행된다
    여기에서는 public void select 실행

- @ResponseBody 

  - 리턴 객체를 http응답으로 전송한다.

-  @RequestParam Map commandMap

  - HTTP 요청 파라미터를 메소드 파라미터에 매핑

  - 여기서는 모든 요청 파라미터를 담은 Map으로 받는다

- @Service
  - 보통 서비스 영역을 구성할 곳에 붙이는 annotation(@Component를 사용해도 상관 없지만 @Service를 사용함으로써 해당 클레스가 서비스 레이어 클래스라는 것을 명확히 알 수 있다)
  - 필요한 서비스들의 목록을 나열할 수 있는 인터페이스들이 들어감
- @Autowired
  - Bean의 의존성을 자동으로 만족시키기 위한 수단
- @Repository
  - DAO에 특화된 어노테이션
  - @Component 어노테이션이 가진 특성과 함꼐, DAO의 메소드에서 발생할 수 있는 unchecked exeception 처리가능





### CommonController.java

@Controller //해당 클래스를 웹 요청을 처리하는 컨트롤러로 사용
public class CommonController {
	

	@Resource(name = "CommonService") //CommonService로 정의된 bean name을 사용
	private CommonService commonService; //commonService로
	
	@RequestMapping(value="/common/select.do") //컨트롤러가 처리할 요청 URL명시
	@ResponseBody //리턴 객체를 http응답으로 전송
	public void select(HttpServletRequest request // http프로토콜의 요청정보 request에 저장
							, HttpServletResponse response // 반환할 reponse 생성
							, @RequestParam Map commandMap // 모든 요청 파라미터를 담은 Map으로 받음) throws Exception {
		System.out.println("Constroller START"); // Constroller Start 출력
		String searchValue = request.getParameter("searchValue"); // searchNalue파라미터 받음
		String[] searchNameValue = searchValue.split("\\|"); split함수를 통해 "|"문자 구분
		System.out.println(searchValue); //searchValue 파라미터 풀력
		System.out.println(commandMap.get("query").toString()); key값이 query인 값 출력
		for(String str : searchNameValue){ //searchnameValue값 하나씩 꺼냄
			String[] tmp = str.split("\\:"); // split함수를 통해 ":"문자 구분
			if(tmp.length==2){ //tmp의 길이가 2이면
				commandMap.put(tmp[0].toString(), tmp[1].toString()); //map에 key,value값으로 저장
			}
		}	
		List<?> gridList = commonService.commonSelect(commandMap); //commonService의 commonSelect 함수에 commandMap 값을 넣어 return된 값을 gridList 파라미터에 저장
		System.out.println(">>> "+gridList); // gridList파마리터 값 출력
		
	    Map resultMap = new HashMap(); // HashMap 파라미터 생성
		resultMap.put("data", gridList); //data라는 key에 gridList 값 저장
	    response.setContentType("text/plain; charset=\"utf-8\""); //ContentType utf-8로 설정
	    response.getWriter().write(new Gson().toJson(resultMap)); //Gson형태로 map값 저장
	    
		System.out.println("TEST END******************************"); //Test End 출력
	}
	
	@RequestMapping(value="/common/test.do") //컨트롤러가 처리할 URL명시
	@ResponseBody
	public Map<String, String> android(HttpServletRequest request) throws Exception {
		
		System.out.println("start!!!!!!!!!!!!!!!!!!"); //start 출력
		
		Map<String, String> result = new HashMap<String, String>(); //HashMap 파리미터 생성 
	
	    result.put("num","1"); // key:num, value:1 저장
	    result.put("day","mon"); // key:day, value mon 저장
	    
	    System.out.println("end!!!!!!!!!!!!!!!!!!"); //end 출력
	
	    return result; // result값 리턴
	}

}





### CommomService.java

public interface CommonService { // CommonService로 interface 생성
	List<?> commonSelect(Map<String, Object> commandMap) throws Exception;
}



### CommonServiceImpl.java

@Service("CommonService")  // name: CommonService
public class CommonServiceImpl extends EgovAbstractServiceImpl implements CommonService{ // CommonService를 상속
	

	@Autowired // 자동으로 Bean 의존성 주입
	private DataSourceTransactionManager transactionManager;
	
	@Resource(name = "CommonDAO") // name: CommonDao인 소스 사용
	private CommonDAO commonDAO;
	
	public List<?> commonSelect(Map<String, Object> commandMap) throws Exception {
		System.out.println("SERVICE 시작 확인 ****************************************"); //SERVICE 시작 확인 출력
		return commonDAO.select(commandMap); //commonDAO에 있는 select함수 실행 값 return	
}

}





### CommonDAO.java

@Repository("CommonDAO") // name : CommonDao
public class CommonDAO extends EgovAbstractMapper {
	

	public List<?> select(Map<String, Object> commandMap)  throws Exception  {
		System.out.println("****DAO 시작 : "+commandMap.get("query").toString()); // DAO 시작 : key가 "query"인 값 출력
		List<?> k = null; // List 객체인 k 파라미터 생성
		k = (List<?>) selectList(commandMap.get("query").toString(),commandMap); // k 파라미터에 쿼리를 실행 값을 list로 받아들임
		return  k;
	}
}





정리 : Controller에서 요청받은 값을 Service로 넘겨서 Service에서는 DAO에 값을 넘겨 DAO에서 데이터를 처리해 Service에게 넘겨주고 Service는 그 값을 Controller에게 넘겨 보여줄수 있게 해준다.