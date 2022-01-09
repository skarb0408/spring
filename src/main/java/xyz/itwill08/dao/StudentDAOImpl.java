package xyz.itwill08.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

//SpringDAO ����� �̿��Ͽ� DAO Ŭ���� �ۼ� - spring-jdbc ���̺귯��
// => JdbcTemplate Ŭ������ ���ø� �޼ҵ带 ȣ���Ͽ� DAO Ŭ���� �ۼ� 
public class StudentDAOImpl implements StudentDAO {
	//Bean Configuration File���� StudentDAOImpl Ŭ������ Spring Bean���� ����� ��
	//JdbcTemplate Ŭ������ Spring Bean�� �ʵ忡 �������Ͽ� �������� ���� - DI(Dependency Injection)
	private JdbcTemplate jdbcTemplate; // ����

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insertStudent(Student student) {
		String sql="insert into student values(?,?,?,?,?)";
		//JdbcTemplate.update(String sql,Object... args) : SQL ���(INSERT, UPDATE, DELETE)��
		//DBMS ������ �����Ͽ� �����ϴ� �޼ҵ� - �������� ����(int) ��ȯ
		// => �Ű������� SQL ��ɰ� InParameter�� ����� ���� ���ʴ�� �����Ͽ� �޼ҵ� ȣ��
		return jdbcTemplate.update(sql, student.getNo(), student.getName()
				, student.getPhone(), student.getAddress(), student.getBirthday());
	}

	@Override
	public int updateStudent(Student student) {
		String sql="update student set name=?,phone=?,address=?,birthday=? where no=?";
		return jdbcTemplate.update(sql, student.getName(), student.getPhone()
				, student.getAddress(), student.getBirthday(), student.getNo());
	}

	@Override
	public int deleteStudent(int no) {
		return jdbcTemplate.update("delete from student where no=?",no);
	}

	@Override
	public Student selectStudent(int no) {
		
		try {
			String sql= "select * from student where no=?";
			// JdbcTemplate.queryForObject(String sql, RowMapper<T> rowMapper, Object... args)
			//  => SQL ���(SELECT)�� DBMS ������ �����Ͽ� �����ϴ� �޼ҵ�
			//  => �������� �˻������ ���׸����� ������ ��ü�� ��ȯ�� ��� ����ϴ� �޼ҵ�
			//  => SQL ���, InParameter�� ���ް�, RowMapper ��ü(��������)�� �Ű������� �����Ͽ� �޼ҵ� ȣ��
			//  => RowMapper ��ü�� ���޹޾� �˻������ Java ��ü(���׸�)�� �����Ͽ� ��ȯ
			//  => InParameter ���ް��� Object �迭�� �ʱⰪ���� �����Ͽ� ���ʴ�� ����
			/*
			return jdbcTemplate.queryForObject(sql, new RowMapper<Student>() {
				// �˻����� �÷����� ���׸����� ������ ��ü�� �ʵ忡 ����ǵ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
				// ResultSet => �˻����
				// int => ���ȣ
				@Override // RowMapper �������̽��� �޼ҵ� �������̵� 
				public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
					Student student= new Student();
					student.setNo(rs.getInt("no"));
					student.setName(rs.getString("name"));
					student.setPhone(rs.getString("phone"));
					student.setAddress(rs.getString("address"));
					student.setBirthday(rs.getString("birthday"));
					return student;
				}
			}, no);
			*/
			// �ؿ� ���� ������ ������ �ִ� Ŭ������ ����� ���
			return jdbcTemplate.queryForObject(sql, new StudentRowMapper(), no);
		} catch (EmptyResultDataAccessException e) {
			// EmptyResultDataAccessException : queryForObject() �޼ҵ忡 ���� ���޵� SQL �����
			// �˻������ �������� ���� ��� �߻��ϴ� ����
			return null;
		}
	}

	@Override
	public List<Student> selectStudentList() {
		// JdbcTemplate.query(String sql, RowMapper<T> rowMapper, Object... args)
		//  => SQL ���(SELECT)�� DBMS ������ �����Ͽ� �����ϴ� �޼ҵ�
		//  => �������� �˻������ ���׸����� ������ ��ü�� ��ҷ��ϴ� List ��ü�� ��ȯ�� ��� ����ϴ� �޼ҵ�
		String sql= "select * from student order by no";
		return jdbcTemplate.query(sql, new RowMapper<Student>() {
			@Override
			// ResultSet >> ArrayList ��ȯ
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student= new Student();
				student.setNo(rs.getInt("no"));
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				student.setBirthday(rs.getString("birthday"));
				return student;			
			}
		});
	}
	
	// RowMapper �������̽��� ��ӹ��� �ڽ�Ŭ���� >> ���� ����� �����ϴ� Ŭ����
	//  => Inner Ŭ������ ����
	public class StudentRowMapper implements RowMapper<Student> {
		// ����
		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			Student student= new Student();
			student.setNo(rs.getInt("no"));
			student.setName(rs.getString("name"));
			student.setPhone(rs.getString("phone"));
			student.setAddress(rs.getString("address"));
			student.setBirthday(rs.getString("birthday"));
			return student;
		}	
	}
}
