import java.util.*;
class Application{
	// HOME SCREEN//
	public static void home(String [] sID,String [] sName, int [] mPF, int[] mDB,int index){
		Scanner input=new Scanner(System.in);
			clearConsole();
			System.out.println("+-------------------------------------------------------------------------------------------------------------------+");
			System.out.println("|\t\t\t\t\tWELCOME TO GDSE MARKS MANAGEMENT SYSTEM\t\t\t\t\t    |");
			System.out.println("+-------------------------------------------------------------------------------------------------------------------+\n");
			System.out.println("[1] Add Students\t\t\t\t\t[2] Add Students With Marks");
			System.out.println("[3] Add Marks\t\t\t\t\t\t[4] Update Student Details");
			System.out.println("[5] Update Marks\t\t\t\t\t[6] Delete Students");
			System.out.println("[7] Print Student Details\t\t\t\t[8] Print Student Ranks");
			System.out.println("[9] Best In Programming Fundementals\t\t\t[10] Best In Database Managemnet System");
			System.out.print("\nEnter an option to continue : ");
				int num=input.nextInt(); 
					switch(num){
						case 1  : clearConsole(); index= addStudents(sID,sName,mPF,mDB,index);break;
						case 2  : clearConsole(); index= addStudentsWithMarks(sID,sName,mPF,mDB,index);break;
						case 3  : clearConsole(); index= addMarks(sID,sName,mPF,mDB,index);break;
						case 4  : clearConsole(); index= updateStudentDetails(sID,sName,mPF,mDB,index);break;
						case 5  : clearConsole(); index= updateMarks(sID,sName,mPF,mDB,index);break;
						case 6  : clearConsole(); index= deleteStudents(sID,sName,mPF,mDB,index);break;
						case 7  : clearConsole(); index= printStudentDetails(sID,sName,mPF,mDB,index);break;
						case 8  : clearConsole(); index= printStudentRanks(sID,sName,mPF,mDB,index);break;
						case 9  : clearConsole(); index= bestInProgrammingFundementals(sID,sName,mPF,mDB,index);break;
						case 10 : clearConsole(); index= BestInDatabaseManagemnetSystem(sID,sName,mPF,mDB,index);break;
						default : clearConsole(); System.out.println("Invalid option"); clearConsole(); home(sID,sName,mPF,mDB,index);
					}
		}
	
	//-------------------------------------------------------------------------------------------------------------------------------//
			
		//CLEAR CONSOLE METHOD//
		
	public final static void clearConsole() { 
			try {
					final String os = System.getProperty("os.name"); 
					if (os.contains("Windows")) {
					new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
					} else {
					System.out.print("\033[H\033[2J"); 
					System.out.flush();
					}
				} catch (final Exception e) {
					e.printStackTrace();
        // Handle any exceptions.
				}
		}
	
	//-------------------------------------------------------------------------------------------------------------------------------//
			
		//TOTAL CALCULATION METHOD//
		
	public static int totalMarks(int mPF[],int mDB[],int y){
			int total=mPF[y]+mDB[y];
				return total;
		}
	
	//-------------------------------------------------------------------------------------------------------------------------------//
			
		//AVERAGE CALCULATING METHOD//
		
	public static double avgMarks(int mPF[],int mDB[],int y){
			int total=totalMarks(mPF,mDB,y);
			double avg=total/(double)2;
				return avg;
		}
	
	//-------------------------------------------------------------------------------------------------------------------------------//
			
		// ADD NEW STUDENT METHOD//
		
	public static  int addStudents(String [] sID,String [] sName, int [] mPF, int[] mDB,int index){
			Scanner input=new Scanner(System.in);
				boolean check=true;
				loop1:
				while(true){
					System.out.println("+-------------------------------------------------------------------------------------------------------------------+");
					System.out.println("|\t\t\t\t\t\tADD NEW STUDENTS\t\t\t\t\t\t    |");
					System.out.println("+-------------------------------------------------------------------------------------------------------------------+\n");
					loop2:
					while(true){
						check=true;
						System.out.print("\nEnter Student ID : ");
						String tempID=input.next();

						for(int i=0;i<index+1;i++){
							if(tempID.equals(sID[i])){
								System.out.print("\nThe Student ID already exists!");
								check=false;
								}else{
									continue;
								}
							}
						if(check==true){
							index++;
							sID[index]=tempID;
							System.out.print("\nEnter Student Name : ");
							sName[index]=input.next();
								loop:
								while(true){
									System.out.print("\nStudent Has Been Added Successfully. \nDo you want to add a new student (Y/n) :");
										String command=input.next();
											switch(command){
												case "Y":
												case "y": clearConsole();continue loop1;
												case "N":
												case "n": clearConsole();home(sID,sName,mPF,mDB,index);	
												default : continue loop; 
												}
								}
						}
				
				}//END OF LOOP 02
			
			}//END OF LOOP 01
			
		}//END OF METHOD
	
	//-------------------------------------------------------------------------------------------------------------------------------//
			
		//ADD STUDENTS WITH MARKS METHOD//
			
	public static  int addStudentsWithMarks(String [] sID,String [] sName, int [] mPF, int[] mDB,int index){
		loop1:
		while(true){
			Scanner input=new Scanner(System.in);
				System.out.println("+-------------------------------------------------------------------------------------------------------------------+");
				System.out.println("|\t\t\t\t\t ADD NEW STUDENT WITH MARKS\t\t\t\t\t\t    |");
				System.out.println("+-------------------------------------------------------------------------------------------------------------------+\n");
			boolean check=true;
			loop2:
			while(true){
				check=true;
				System.out.print("\nEnter Student ID : ");
				String tempID=input.next();
					for(int i=0;i<index+1;i++){		
						if(tempID.equals(sID[i])){
							System.out.println("\nThe Student ID already exists");
							check=false;
							continue ;		
						}
					}
					
				if(check==true){
					index++;
					sID[index]=tempID;
						System.out.print("\nEnter Student Name : ");
						sName[index]=input.next();
							loop3:	
								while(true){
									System.out.print("\nProgramming Fundamentals Marks : ");
										int pf=input.nextInt();
											if(pf<0||pf>100){
												System.out.print("\nInvalid Marks! Please Enter Correct Marks. ");
												continue loop3;
											}else{
												mPF[index]=pf;
												break loop3;
												}
								}//END OF LOOP 03
							loop4:
								while(true){
									System.out.print("\nDatabase Management System Marks : ");
										int db=input.nextInt();
											if(db<0||db>100){
												System.out.println("\nInvalid Marks! Please Enter Correct Marks.");
												continue loop4;
											}else{
												mDB[index]=db;
												break loop4;
												}
								}//END OF LOOP 04
						
						loop:
						while(true){
							System.out.print("Student and Marks Has Been Added Successfully. \nDo you want to add a new student (Y/n) :");
								String command=input.next();
									switch(command){
										case "Y":
										case "y":clearConsole();continue loop1;
										case "N":
										case "n":clearConsole();home(sID,sName,mPF,mDB,index);	
										default :continue loop;
									}
						}
					}//END OF IF CONDITION
				}//END OF LOOP 02
			}//END OF LOOP 01
		
		}//END OF METHOD
	
	//-------------------------------------------------------------------------------------------------------------------------------//
		
		//ADD MARKS METHOD//
	
	public static  int addMarks(String [] sID,String [] sName, int [] mPF, int[] mDB,int index){
		Scanner input=new Scanner(System.in);
			loop1:
			while(true){
				int count = 0;
					System.out.println("+-------------------------------------------------------------------------------------------------------------------+");
					System.out.println("|\t\t\t\t\t\tADD MARKS\t\t\t\t\t\t\t    |");
					System.out.println("+-------------------------------------------------------------------------------------------------------------------+\n");
				loop2:
				while(true){
					System.out.print("Enter Student ID : ");
						String tempID=input.next();
							for(int i=0;i<index+1;i++){
								if(tempID.equals(sID[i])){
									count=i;
										break;
								}else{
								continue;
								}
							}	
					if(count!=0){
						System.out.println("Student Name : "+sName[count]);
					if((mPF[count])>0){
							System.out.println("This Student's Marks Have Been Already Added. \nIf You Want Update Marks, Please use [4] Update Marks option. ");
								loop:
								while(true){
									System.out.print("Do you want to search again? (Y/n) : ");
										String command=input.next();
											switch(command){
													case "Y":
													case "y":continue loop2;
													case "N":
													case "n":clearConsole();home(sID,sName,mPF,mDB,index);	
													default :continue loop;
											}
								}
							}
						loop3:	
						while(true){
							System.out.print("Programming Fundamentals Marks : ");
								int pf=input.nextInt();
									if(pf<0||pf>100){
										System.out.println("Invalid marks, please enter correct marks. \n\n");
										continue loop3;
									}else{
										mPF[count]=pf;
										break loop3;
										}
						}//	END OF LOOP 03
						loop4:
						while(true){
							System.out.print("Database Management System Marks : ");
								int db=input.nextInt();
									if(db<0||db>100){
										System.out.println("Invalid Marks, Please Enter Correct Marks. \n\n");
										continue loop4;
									}else{
										mDB[count]=db;
										break loop4;
										}
						}//END OF LOOP 04
							loop:
							while(true){
								System.out.print("Marks Have Been Added Sucessfully.\nDo You Want To Add Marks For Another Student? (Y/n) :");
									String command=input.next();
										switch(command){
											case "Y":
											case "y":clearConsole();continue loop1;
											case "N":
											case "n":clearConsole();home(sID,sName,mPF,mDB,index);	
											default : continue loop;
										}
							}
					}//END OF IF CONDITION 
					if(count==0){
						loop:
						while(true){
							System.out.print("Invalid Student ID. Do You Want To Search Again? (Y/n) :");
								String command=input.next();
									switch(command){
										case "Y":
										case "y":continue loop2;
										case "N":
										case "n":clearConsole();home(sID,sName,mPF,mDB,index);	
										default :continue loop;	
									}
								}
						}//END IF CONDITION
					count=0;
					}	//END OF LOOP 02
				}//END OF LOOP 01
		  }//END OF METHOD
			
	//-------------------------------------------------------------------------------------------------------------------------------//
		
			//UPDATE STUDENT DETAILS METHOD//
		
	public static  int updateStudentDetails(String [] sID,String [] sName, int [] mPF, int[] mDB,int index){
		Scanner input=new Scanner(System.in);
			loop1:
			while(true){
				System.out.println("+-------------------------------------------------------------------------------------------------------------------+");
				System.out.println("|\t\t\t\t\tUPDATE STUDENT DETAILS\t\t\t\t\t\t\t    |");
				System.out.println("+-------------------------------------------------------------------------------------------------------------------+\n");
					boolean check =false;
				loop2:
				while(true){
					System.out.print("\nEnter Student ID : ");
						String tempID=input.next();
							for(int i=0; i<index+1; i++){
								if(tempID.equals(sID[i])){
									System.out.print("\nCurrent Name : "+sName[i]);
									System.out.print("\nNew Name : ");
										sName[i]=input.next();
										check=true;
											loop:
											while(true){
												System.out.print("Student Has Been Updated Sucessfully.\nDo you want to update more Students? (Y/N)");
													String command=input.next();
														switch(command){
															case "Y" :
															case "y" : clearConsole();continue loop1;
															case "N" :
															case "n" :clearConsole(); home(sID,sName,mPF,mDB,index);
															default :continue loop;
														}
												}
								}else{
									continue ;
									}
							}//END OF FOR LOOP
						if(check==false){
							loop:
							while(true){
								System.out.print("\nStudent do not exists! Do you Want To Search Again.(Y/n)");
									String command=input.next();
										switch(command){
											case "Y":
											case "y":continue loop2;
											case "N":
											case "n":clearConsole();home(sID,sName,mPF,mDB,index);	
											default :continue loop;
										}
								}
						}
				
				}//END OF LOOP 02
			}//END OF LOOP 01
		}//END OF METHOD
		
	//-------------------------------------------------------------------------------------------------------------------------------//
		
		//UPDATE MARKS METHOD//
		
	public static  int updateMarks(String [] sID,String [] sName, int [] mPF, int[] mDB,int index){
			Scanner input=new Scanner(System.in);
				loop1:
				while(true){
					System.out.println("+-------------------------------------------------------------------------------------------------------------------+");
					System.out.println("|\t\t\t\t\t\tUPDATE MARKS\t\t\t\t\t\t\t    |");
					System.out.println("+-------------------------------------------------------------------------------------------------------------------+\n");
						int y=0;
					loop2:
					while(true){
						int x=0;
						System.out.print("\nEnter Student ID  : ");
							String tempID=input.next();
								for(int i=0; i<index+1; i++){
									if(tempID.equals(sID[i])){
										x=1;
										if(mPF[i]==0){
											x=2;
											break;
										}else{
											x=3;
											y=i;
											break;
										}
									}else{
										continue; //For loop
									}
								}//END OF FOR LOOP
						if(x==0){
							loop:
							while(true){
								System.out.print("\nInvalid Student Number.\nDo You Want To Search Again? (Y/n) ");
									String command=input.next();
										switch(command){
											case "Y" :
											case "y" : continue loop2;
											case "N" :
											case "n" : clearConsole();home(sID,sName,mPF,mDB,index);
											default : continue loop;
										}
									}
							}//END OF IF CONDITION 01
						if(x==2){
							loop:
							while(true){
								System.out.print("\nInvalid Student Number.\nDo You Want To Search Again? (Y/n) ");
									String command=input.next();
										switch(command){
											case "Y" :
											case "y" : continue loop2;
											case "N" :
											case "n" : clearConsole();home(sID,sName,mPF,mDB,index);
											default : continue loop;
										}
									}
						}//END OF IF CONDITION 02
						if(x==3){
							System.out.print("\nCurrent Programming Fundemental Marks : "+mPF[y]);
							System.out.print("\nCurrent Database Management Marks : "+mDB[y]);
							
							loop3:	
							while(true){
								System.out.print("\nProgramming Fundamentals Marks : ");
									int pf=input.nextInt();
									if(pf<0||pf>100){
										System.out.print("\nInvalid marks, please enter correct marks. \n\n");
										continue loop3;
									}else{
										mPF[y]=pf;
										break;
									}
							}//END OF LOOP 03
							loop4:
							while(true){
								System.out.print("\nDatabase Management System Marks : ");
									int db=input.nextInt();
									if(db<0||db>100){
										System.out.print("\nInvalid marks, please enter correct marks. ");
										continue loop4;
									}else{
										mDB[y]=db;
										break;
									}
							}//END OF LOOP 04
							loop:
							while(true){
								System.out.print("\nMarks Have Been Updated Sucessfully. Do you want to update marks of another student? (Y/n) :");
									String command=input.next();
										switch(command){
											case "Y" :
											case "y" : clearConsole();continue loop1;
											case "N" :
											case "n" : clearConsole();home(sID,sName,mPF,mDB,index);
											default  :continue loop;
										}
									}	
							}//END OF IF CONDITION 03
						}//END OF LOOP 02
					}//END OF LOOP 01
		}// END OF METHOD
		
	//-------------------------------------------------------------------------------------------------------------------------------//
		
		//DELETE STUDENTS METHOD//
		
	public static  int  deleteStudents(String [] sID,String [] sName, int [] mPF, int[] mDB,int index){
		Scanner input=new Scanner(System.in);
			loop1:
			while(true){
			System.out.println("+-------------------------------------------------------------------------------------------------------------------+");
			System.out.println("|\t\t\t\t\t\tDelete Student\t\t\t\t\t\t\t    |");
			System.out.println("+-------------------------------------------------------------------------------------------------------------------+\n");
			int a=0;
			int x=0;
			
				loop2:
				while(true){
					boolean check=false;
						System.out.print("\nEnter Student ID : ");
							String tempID=input.next();
								for(int i=0; i<index+1; i++){
									if(tempID.equals(sID[i])){
										System.out.print("\nCurrent Name : "+sName[i]);
												index--;
											sID[i]=null;
											sName[i]=null;
											mPF[i]=0;
											mDB[i]=0;
											check=true;
												break;
									}else{
										continue; //CONTINUE FOR LOOP
									}
								}//END OF FOR LOOP
						if(check==false){
							loop:
							while(true){
								System.out.print("\nStudent do not exists.\nDo You Want To Search Again? (Y/n) ");
									String command=input.next();
										switch(command){
											case "Y" :
											case "y" :continue loop2;
											case "N" :
											case "n" :clearConsole();home(sID,sName,mPF,mDB,index);
											default  :continue loop;
										}
								}
						}
					System.out.print("\nStudent has been deleted successfully!");
					loop:
					while(true){
						System.out.print("\nDo you want to delete more Students? (Y/N)");
							String command=input.next();
								switch(command){
									case "Y" :
									case "y" :continue loop1;
									case "N" :
									case "n" :clearConsole();home(sID,sName,mPF,mDB,index);
									default  :continue loop;
								}
					}
				}//END OF LOOP 02
			}//END OF LOOP 01
		}//END OF METHOD
			
	//-------------------------------------------------------------------------------------------------------------------------------//
		
		//PRINT STUDENT DETAIL METHOD//
		
	public static  int printStudentDetails(String [] sID,String [] sName, int [] mPF, int[] mDB,int index){
			Scanner input=new Scanner(System.in);
				loop1:
				while(true){
					System.out.println("+-------------------------------------------------------------------------------------------------------------------+");
					System.out.println("|\t\t\t\t\t\tPRINT STUDENT DETAILS\t\t\t\t\t\t    |");
					System.out.println("+-------------------------------------------------------------------------------------------------------------------+\n");
					loop2:
					while(true){
						boolean check=false;
						int count=1;
						int y=0;
							System.out.print("\nEnter Student ID : ");
								String tempID=input.next();
									for(int i=0; i<index+1; i++){
										if(tempID.equals(sID[i])){
											y=i;
											if(mPF[i]!=0){
												check=true;
												break; 
											}else{
												continue;
											}
										}else{
											continue; 
										}
									}//END OF FOR LOOP
						if(y!=0&&check==false){
							System.out.print("\nMarks Yet To Be Added.\nDo You Want to Search Again ?(Y/n) ");
								String command=input.next();
									switch(command){
										case "Y" :
										case "y" :continue loop2;
										case "N" :
										case "n" :clearConsole();home(sID,sName,mPF,mDB,index);
									}
							}		
							
					if(check==true){
						int total[]=new int[index+1];
						double avg[]=new double [index+1];
						
								for(int i=0; i<index+1; i++){
									total[i]=totalMarks(mPF,mDB,i);
									avg[i]=avgMarks(mPF,mDB,i);
								}
						
									for(int i=0; i<index+1; i++){
										if(total[y]<total[i]){
											count++;
										}else{
											continue;
										}
									}
									
										int limit=0;
											for(int i=0;i<index+1; i++){
												if(sID[i]!=null&&mPF[i]!=0){
													limit++;
												}else{
													continue;
												}
											}
											
						System.out.println("Student's Name : "+sName[y]);
						System.out.print("+-----------------------------------+---------------------+\n");
						System.out.println("| Programming Fundemental Marks     | " +"\t\t"+mPF[y]+"\t  |");
						System.out.println("| Databse Management System Marks   | " +"\t\t"+mDB[y]+"\t  |");
						System.out.println("| Toatal                            | " +"\t\t"+total[y]+"\t  |");
						System.out.println("| Average                           | " +"\t\t"+avg[y]+"\t  |");
						if(count==1){
							System.out.print  ("| Rank                              |"+"\t\t(Fisrt)"+count+"  |\n");
						}else if(count==2){
							System.out.print  ("| Rank                              |"+"\t\t(Second)"+count+" |\n");
							}else if(count==3){
								System.out.print  ("| Rank                              |"+"\t\t(Third)"+count+"  |\n");
								}else if (count==limit){
									System.out.print  ("| Rank                              |"+"\t\t(Last)"+count+"  |\n");
									}else{
										System.out.print  ("| Rank                              |"+"\t\t"+count+"\t  |\n");
										}
						System.out.println("+-----------------------------------+---------------------+");
				
							System.out.print("\n\nDo You Want To Print More Student Details ?(Y/n) ");
								String command=input.next();
									switch(command){
										case "Y" :
										case "y" :clearConsole();continue loop1;
										case "N" :
										case "n" :clearConsole();home(sID,sName,mPF,mDB,index);
									}
					}
					if(check==false){
						System.out.print("\nStudent ID do not exists.");
						loop:
						while(true){
							System.out.print("\nDo You Want To Search Again ? (Y/n)");
								String command=input.next();
									switch(command){
										case "Y" :
										case "y" :continue loop2;
										case "N" :
										case "n" :clearConsole();home(sID,sName,mPF,mDB,index);
										default  :continue loop;
									}
							}
					}
			
				}//END OF LOOP 02
			}//END OF LOOP 01
		}//END OF METHOD
				
	//-------------------------------------------------------------------------------------------------------------------------------//
		
		//PRINT STUDENT RANKS METHOD//
		
	public static  int printStudentRanks(String [] sID,String [] sName, int [] mPF, int[] mDB,int index){
		Scanner input=new Scanner(System.in);
			loop1:
			while(true){
				System.out.println("+-------------------------------------------------------------------------------------------------------------------+");
				System.out.println("|\t\t\t\t\t\tPRINT STUDENTS' RANK\t\t\t\t\t\t    |");
				System.out.println("+-------------------------------------------------------------------------------------------------------------------+\n");
				
				loop2:
				while(true){
					
			//Assigning current arrays to a tempary array to sort
					String []tempID=new String[index+1];
						String tempI="";
					String []tempName=new String[index+1];
						String tempN="";
						int tempTotal=0;
						double tempAvg=0.0;
					int total[]=new int [index+1];
					double avg[]=new double[index+1];
					// Finding total and average
						for(int i=0; i<index+1; i++){
							total[i]=totalMarks(mPF,mDB,i);
							avg[i]=avgMarks(mPF,mDB,i);
						}
				//Finding limit to stop printing null values when marks haven't been inserted
							int limit=0;
								for(int i=0;i<index+1; i++){
									if(sID[i]!=null&&mPF[i]!=0){
										tempID[i]=sID[i];
										tempName[i]=sName[i];
											limit++;
									}else{
										continue;
									}
								}
						//Sorting tempary arrays
							for (int i = 0; i < index+1; i++){
								for (int j = i + 1; j < index+1; j++){
									if (total[i] < total[j]){
										tempTotal=total[i]; 
										tempI=tempID[i];
										tempN=tempName[i];
										tempAvg=avg[i];
												
												total[i]=total[j];
												tempID[i]=tempID[j];
												tempName[i]=tempName[j];
												avg[i]=avg[j];
					
													total[j]=tempTotal; 
													tempID[j]=tempI;
													tempName[j]=tempN;
													avg[j]=tempAvg;
									}  
								}  
							}
							if(limit==0){
								System.out.print("\nNo student's marks have been added.");
								
								}else{
									System.out.println("+-------+-------+---------------+---------------+------------+");
									System.out.println("| Rank  | sID   | Name          | Total         | Avg        | ");
									System.out.println("+-------+-------+---------------+---------------+------------+");
										for(int i=0;i<limit;i++){
											System.out.println("|"+(i+1)+"\t|"+tempID[i]+"   |"+tempName[i]+"\t\t|\t"+total[i]+"\t|\t"+avg[i]+" |");
										}
	
									System.out.println("+-------+-------+---------------+---------------+------------+");
								}
						loop:
						while(true){
							System.out.print("\nDo you want to back to main menu ?(Y/n) ");
									String command=input.next();
										switch(command){
											case "Y" :
											case "y" :clearConsole();home(sID,sName,mPF,mDB,index);
											case "N" :
											case "n" : clearConsole();continue loop1;
											default  :continue loop;
											}
						}
				}//END OF LOOP 02
			}//END OF LOOP 01
	
		} //END OF METHOD
		
	//-------------------------------------------------------------------------------------------------------------------------------//
		
			//BEST IN PROGRAMMING FUNDEMENTAL METHOD//
			
	public static  int bestInProgrammingFundementals(String [] sID,String [] sName, int [] mPF, int[] mDB,int index){
			Scanner input=new Scanner(System.in);
				loop1:
				while(true){
					System.out.println("+-------------------------------------------------------------------------------------------------------------------+");
					System.out.println("|\t\t\t\t\t\tBEST IN PROGRAMMING FUNDEMENTALS\t\t\t\t    |");
					System.out.println("+-------------------------------------------------------------------------------------------------------------------+\n");
						loop2:
						while(true){
						//Assigning current arrays to temporary arrays to sort
							String []tempID=new String[index+1];
								String tempI="";
							String []tempName=new String[index+1];
								String tempN="";
							int tempPF[]=new int [index+1];
								int tempP=0;
							int tempDB[]=new int[index+1];
								int tempD=0;
						
							//Finding limit to stop printing null values when marks haven't been inserted
									int limit=0;
										for(int i=0;i<index+1; i++){
											if(sID[i]!=null&&mPF[i]!=0){
												tempID[i]=sID[i];
												tempName[i]=sName[i];
												tempPF[i]=mPF[i];
												tempDB[i]=mDB[i];
													limit++;
											}else{
												continue;
											}
										}
										if(limit==0){
											System.out.print("\nNo student's marks have been added. ");
										}else{
										
							//Sorting temporary arrays
									for (int i = 0; i < index+1; i++){
										for (int j = i + 1; j < index+1; j++){
											if (tempPF[i] < tempPF[j]){
												tempP = tempPF[i];  
												tempI = tempID[i];
												tempN = tempName[i];
												tempD = tempDB[i];
													tempPF[i]=tempPF[j];
													tempID[i]=tempID[j];
													tempName[i]=tempName[j];
													tempDB[i]= tempDB[j]; 
														tempPF[j] =tempP;  
														tempID[j]=tempI ;
														tempName[j]=tempN;
														tempDB[j]=tempD;
											}
										}
									}
										System.out.println("+-------+----------------+----------+----------+");
										System.out.println("|sID    |    Name        |PF marks  |DB marks  |");
										System.out.println("+-------+----------------+----------+----------+");
											for(int i=0; i<limit; i++){
												System.out.println("|"+tempID[i]+"\t|"+tempName[i]+"\t\t |"+tempPF[i]+"\t    |"+tempDB[i]+"\t       |");
											}
										System.out.println("+-------+----------------+----------+----------+");
									}
						loop:
						while(true){
							System.out.print("\nDo you want to back to main menu ?(Y/n) ");
									String command=input.next();
										switch(command){
											case "Y" :
											case "y" :clearConsole();home(sID,sName,mPF,mDB,index);
											case "N" :
											case "n" :clearConsole(); continue loop1;
											default  :continue loop;
											}
						}
					}//END OF LOOP 02  
				}//END OF LOOP1  
		}// END OF METHOD
		
					
	//-------------------------------------------------------------------------------------------------------------------------------//
		
			//BEST IN DATABASE MANAGEMENT SYSTEM METHOD//						
		
	public static  int BestInDatabaseManagemnetSystem(String [] sID,String [] sName, int [] mPF, int[] mDB,int index){
		Scanner input=new Scanner(System.in);
			loop1:
			while(true){
				System.out.println("+-------------------------------------------------------------------------------------------------------------------+");
				System.out.println("|\t\t\t\t\t\tBEST IN DATABASE MANAGEMENT SYSTEM\t\t\t\t    |");
				System.out.println("+-------------------------------------------------------------------------------------------------------------------+\n");
					loop2:
					while(true){
					//Assigning current arrays to temporary arrays to sort
						String []tempID=new String[index+1];
							String tempI="";
						String []tempName=new String[index+1];
							String tempN="";
						int tempDB[]=new int [index+1];
							int tempD=0;
						int tempPF[]=new int [index+1];
								int tempP=0;
						
						//Finding limit to stop printing null values when marks haven't been inserted
								int limit=0;
									for(int i=0;i<index+1; i++){
										if(sID[i]!=null&&mPF[i]!=0){
											tempID[i]=sID[i];
											tempName[i]=sName[i];
											tempDB[i]=mDB[i];
											tempPF[i]=mPF[i];
												limit++;
										}else{
											continue;
										}
									}
								if(limit==0){
									System.out.print("\nNo student's marks have been added. ");
								}else{
										
							//Sorting temporary arrays
									for (int i = 0; i < index+1; i++){
										for (int j = i + 1; j < index+1; j++){
											if (tempDB[i] < tempDB[j]){
												tempP = tempPF[i];  
												tempI = tempID[i];
												tempN = tempName[i];
												tempD = tempDB[i];
													tempPF[i]=tempPF[j];
													tempID[i]=tempID[j];
													tempName[i]=tempName[j];
													tempDB[i]= tempDB[j]; 
														tempPF[j] =tempP;  
														tempID[j]=tempI ;
														tempName[j]=tempN;
														tempDB[j]=tempD;
											}
										}
									}
										System.out.println("+-------+----------------+----------+----------+");
										System.out.println("|sID    |    Name        |DB marks  |PF marks  |");
										System.out.println("+-------+----------------+----------+----------+");
											for(int i=0; i<limit; i++){
												System.out.println("|"+tempID[i]+"\t|"+tempName[i]+"\t\t |"+tempDB[i]+"\t    |"+tempPF[i]+"\t       |");
											}
										System.out.println("+-------+----------------+----------+----------+");
									}
							loop:
							while(true){
								System.out.print("\nDo you want to back to main menu ?(Y/n) ");
									String command=input.next();
										switch(command){
											case "Y" :
											case "y" :clearConsole();home(sID,sName,mPF,mDB,index);
											case "N" :
											case "n" :clearConsole(); continue loop1;
											default  :continue loop;
											}
								}
									
						}//END OF LOOP 02  
				}//END OF LOOP1  
		}// END OF METHOD
							
	
	
	
	public static void main(String [] args){
		String [] sID=new String [1000];
		String [] sName=new String [1000];
		int [] mPF=new int [1000];
		int [] mDB=new int [1000];
		int index=1;
		home(sID,sName,mPF,mDB,index);
		}
	}
