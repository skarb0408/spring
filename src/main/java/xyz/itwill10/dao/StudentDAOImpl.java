package xyz.itwill10.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import xyz.itwill10.dto.Student;
import xyz.itwill10.mapper.StudentMapper;

// Spring MVC���� Mybatis Frameork�� �̿��Ͽ� DAO Ŭ���� �ۼ� ���
// 1. DataSource ���� ���̺귯���� Mybatis ���� ���̺귯�� ���� ó��
//  	=> ojdbc, spring-jdbc ���̺귯��, mybatis ���̺귯��, mybatis-spring  ���̺귯��
// 2. Mybatis Framework�� ȯ�漳�� ���� �ۼ�
// 3. SqlSessionFactory ���� Ŭ������ SqlSession ���� Ŭ������ Spring Bean���� ���
//  	=> Bean Configuration File(root-context.xml)�� bean ������Ʈ ���??
// 4. DTO Ŭ���� �ۼ�
// 5. Mapper �ۼ� - XMl ���� ���ϰ� Interface ���� ������ ���ε��Ͽ� �ۼ�
// 6. DAO Ŭ���� �ۼ� - Mapper�� ��ϵ� SQL ����� �����Ͽ� �����Ͽ� ����� ��ȯ

// Mybatis Framework���� �����Ǵ� �α׸� Spring �α� ����ü�� ��ϵǵ��� �����ϴ� ���
// 1. log4jdbc-log4j2-jdbc4 ���̺귯�� ����ó�� >> pom.xml
// 2. DataSource ���� Ŭ������ Spring Bean���� ����ϴ� ������Ʈ���� driverClassName �ʵ��
//						url �ʵ带 log4jdbc-log4j2-jdbc4 ���̺귯������ �����Ǵ� ������ ������ ó�� >> root-context.xml
// 3. src/main/resources ������ log4jdbc.log4j2.properties ���� �ۼ�
// 4. log4j.xml ���Ͽ��� �α� �̺�Ʈ�� ���� ��� ����

// DAO Ŭ���� : �����ü�� �࿡ ���� ����, ����, ����, �˻� ����� �����ϴ� Ŭ����
//  => DBMS ������ SQL ����� �����Ͽ� ������ ����� Java �ڷ����� ��ü�� ��ȯ�ϴ� ����� �޼ҵ�

// @Repository : DAO Ŭ������ Spring Bean���� ����ϱ� ���� ������̼� >> DAO Ŭ���� �Ҷ� ��
//  => Ʈ������ �Ŵ��� ���� ����� �����޾� ��� >> [Ʈ������ ã�ƺ���, Rollback, Commit] 
// Spring Container���� ������̼��� ó���ϱ� ���� Bean Configuration File(servlet-context.xml)���� 
// componet-scan ������Ʈ�� ����Ͽ� DAO Ŭ������ �ۼ��� ��Ű�� ���� >> Spring Bean���� ���
@Repository
public class StudentDAOImpl implements StudentDAO {
		// SqlSession ���� Ŭ������ ��ϵ� Spring Bean ��ü�� �ʵ忡 ������ ó��
		//  => DAO Ŭ������ �޼ҵ忡�� SqlSession ��ü�� �޼ҵ带 ȣ�� ����
		// @Autowired  ������̼ǰ� @Qualifier(Spring Bean�� ������ �϶�)�� ����Ͽ� ������ ó��
		//  => �ʵ帶�� ������̼��� �̿��Ͽ� ������ ó��
		@Autowired // => Setter �� ��� Setter Injection�� �ڵ����� ó���ȴ�.
		private SqlSession sqlSession;
		
	@Override
	public int insertStudent(Student student) {
		return sqlSession.getMapper(StudentMapper.class).insertStudent(student);
	}

	@Override
	public List<Student> selectStudentList() {
		return sqlSession.getMapper(StudentMapper.class).selectStudentList();
	}
	
}
