import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation
{

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) 
	{
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents()
	{
		return this.students;
	}

	@Override
	public void setStudents(Student[] students)
	{
		if(students==null)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			this.students = students;
		}
	}

	@Override
	public Student getStudent(int index) 
	{
		if(index<0 || index>= this.students.length)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			return this.students[index];
		}
	}

	@Override
	public void setStudent(Student student, int index)
	{
		if(index<0 || index>= this.students.length || this.students==null)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			this.students[index] = student;
		}
	}

	@Override
	public void addFirst(Student student)
	{
		if(this.students==null)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			ArrayList<Student> array = new ArrayList<Student>();
			for(int i=0;i<this.students.length;i++)
			{
				array.add(this.students[i]);
			}
			array.add(0, student);
			this.students =  (Student[]) array.toArray(students);
		}
	}

	@Override
	public void addLast(Student student) 
	{
		if(this.students==null)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			ArrayList<Student> array = new ArrayList<Student>();
			for(int i=0;i<this.students.length;i++)
			{
				array.add(this.students[i]);
			}
			array.add(this.students.length, student);
			this.students =  (Student[]) array.toArray(students);
		}
	}

	@Override
	public void add(Student student, int index)
	{
		if(index<0 || index>= this.students.length || this.students==null)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			ArrayList<Student> array = new ArrayList<Student>();
			for(int i=0;i<this.students.length;i++)
			{
				array.add(this.students[i]);
			}
			array.add(index, student);
			this.students =  (Student[]) array.toArray(students);
		}
	}

	@Override
	public void remove(int index)
	{
		if(index<0 || index>= this.students.length || this.students==null)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			ArrayList<Student> array = getArrayList();
			array.remove(index);
			this.students =  (Student[]) array.toArray(students);
		}
	}
	
	

	@Override
	public void remove(Student student)
	{
		if(this.students==null)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			ArrayList<Student> array = getArrayList();
			int i;
			for(i=0;i<this.students.length;i++)
			{
				if(students[i].equals(student))
				{
					array.remove(i);
					break;
				}
			}
			if(i==this.students.length)
			{
				throw new IllegalArgumentException("Student not exist");
			}
			else
				this.students =  (Student[]) array.toArray(students);
		}
	}

	@Override
	public void removeFromIndex(int index)
	{
		if(index<0 || index>= this.students.length || this.students==null)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			ArrayList<Student> array = getArrayList();
			for(int i=index+1;i<this.students.length;i++)
			{
				array.remove(i);
			}
			this.students =  (Student[]) array.toArray(students);
		}
	}

	@Override
	public void removeFromElement(Student student)
	{
		if(this.students==null)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			ArrayList<Student> array = getArrayList();
			int i;
			for(i=0;i<this.students.length;i++)
			{
				if(array.get(i).equals(student))
				{
					break;
				}
			}
			for(i=i+1;i<this.students.length;i++)
			{
				array.remove(i);
			}
			this.students =  (Student[]) array.toArray(students);
		}
	}

	@Override
	public void removeToIndex(int index)
	{
		if(index<0 || index>=this.students.length || this.students==null)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			ArrayList<Student> array = getArrayList();
			for(int i=0;i<index;i++)
			{
				array.remove(i);
			}
			this.students =  (Student[]) array.toArray(students);
		}
	}

	@Override
	public void removeToElement(Student student) 
	{
		if( this.students==null)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			ArrayList<Student> array = getArrayList();
			for(int i=0;i<this.students.length;i++)
			{
				if(array.get(i).equals(student))
				{
					break;
				}
				else
				{
					array.remove(i);
				}
				
			}
			this.students =  (Student[]) array.toArray(students);
		}
	}

	@Override
	public void bubbleSort()
	{
		int n = this.students.length;  
        Student temp = null;  
        for(int i=0; i < n; i++)
        {  
        	for(int j=1; j < (n-i); j++)
        	{  
        		if(students[j-1].getId() > students[j].getId())
        		{  
        			//swap elements  
        			temp = students[j-1];  
        			students[j-1] = students[j];  
        			students[j] = temp;  
        		}  

        	}  
        }  
	}

	@Override
	public Student[] getByBirthDate(Date date)
	{
		if(date == null)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			ArrayList<Student> ans = new ArrayList<Student>();
			for(int i=0;i<this.students.length;i++)
			{
				if(students[i].getBirthDate().before(date) || students[i].getBirthDate().equals(date))
				{
					ans.add(students[i]);
				}
			}
			return (Student[]) ans.toArray(students);
		}
		
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) 
	{
		if(firstDate == null || lastDate == null)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			ArrayList<Student> ans = new ArrayList<Student>();
			for(int i=0;i<this.students.length;i++)
			{
				if(	(students[i].getBirthDate().after(firstDate) && students[i].getBirthDate().before(lastDate)) 
						|| students[i].getBirthDate().equals(firstDate)
						|| students[i].getBirthDate().equals(lastDate))
				{
					ans.add(students[i]);
				}
			}
			return (Student[]) ans.toArray(students);
		}
		
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days)
	{
		if(date == null )
		{
			throw new IllegalArgumentException();
		}
		else
		{
			ArrayList<Student> ans = new ArrayList<Student>();
			
			Date newDate = addDays(date, days);
	        
			
			
			for(int i=0;i<this.students.length;i++)
			{
				if(	(students[i].getBirthDate().after(date) && students[i].getBirthDate().before(newDate))
						|| students[i].getBirthDate().equals(date)
						|| students[i].getBirthDate().equals(newDate))
				{
					ans.add(students[i]);
				}
			}
			return (Student[]) ans.toArray(students);
		}
	}
	
	public static Date addDays(Date date, int days)
	{
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
				
		return cal.getTime();
	}
	
	
	

	@Override
	public int getCurrentAgeByDate(int indexOfStudent)
	{
		if(indexOfStudent== 0)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			Student student = this.students[indexOfStudent];
			Date date = new Date();
			int age = this.students[indexOfStudent].getBirthDate().getYear() - date.getYear();
			return age;
			
		}
		
	}

	@Override
	public Student[] getStudentsByAge(int age)
	{
		Date date = new Date();
		ArrayList<Student> ans = new ArrayList<Student>();
		for(int i=0;i<students.length;i++)
		{
			if(this.students[i].getBirthDate().getYear() - date.getYear() == age )
			{
				ans.add(this.students[i]);
			}
		}
		return (Student[]) ans.toArray(students);
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark()
	{
		float avg =0;
		ArrayList<Student> ans = new ArrayList<Student>();
		for(int i=0;i<this.students.length;i++)
		{
			avg += this.students[i].getAvgMark();
		}
		avg= avg /this.students.length;
		for(int i=0;i<this.students.length;i++)
		{
			if(this.students[i].getAvgMark()> avg)
				ans.add(this.students[i]);
		}
		return (Student[]) ans.toArray(students);
		
	}

	@Override
	public Student getNextStudent(Student student) 
	{
		if(student == null)
		{
			throw new   IllegalArgumentException();
		}
		int i;
		for(i=0;i<students.length;i++)
		{
			if(this.students[i].equals(student) )
			{
				break;
			}
		}
		return students[i+1];
		
	}
	
	
	public ArrayList<Student> getArrayList()
	{
		ArrayList<Student> array = new ArrayList<Student>();
		for(int i=0;i<this.students.length;i++)
		{
			array.add(this.students[i]);
		}
		return array;
	}
	
	public void show()
	{
		for(int i=0;i<this.students.length;i++)
		{
			System.out.print(students[i].getFullName()+"\t"+students[i].getId());
			System.out.print(students[i].getAvgMark()+"\t"+students[i].getBirthDate());
		}
	}
}
