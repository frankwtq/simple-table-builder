package com.lsj.stb.sql.field;

public class SqlServerField extends AbstractSqlField implements SqlField{
	
	protected SqlServerField(String name, String chineseName, String type, Integer length, String desc) {
		super(name, chineseName, type, length, desc);
	}

	@Override
	public String createSql(){
		StringBuilder sqlsb = new StringBuilder();
		if(length != -1){
			sqlsb.append(String.format( "%s %s(%d) ", name, type, length));
		}else{
			sqlsb.append(String.format(" %s %s ", name, type));
		}
		if(isPrimaryKey){sqlsb.append(" primary key ");}
		if(isAutoIncrement){sqlsb.append(" identity ");}
		if(isNotNull){sqlsb.append(" not null ");}
		
		return sqlsb.toString();
	}
	
	static public class Builder extends SqlFieldBuilder{
		@Override
		public SqlField doBuild(String name, String chineseName, String type, Integer length, String desc) {
			return new SqlServerField(name, chineseName, type, length, desc);
		}
	}
}
