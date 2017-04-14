@echo off
if not exist "db_dumps" mkdir db_dumps
cd db_dumps

:: Check WMIC is available
WMIC.EXE Alias /? >NUL 2>&1 || GOTO s_error

:: Use WMIC to retrieve date and time
FOR /F "skip=1 tokens=1-6" %%G IN ('WMIC Path Win32_LocalTime Get Day^,Hour^,Minute^,Month^,Second^,Year /Format:table') DO (
   IF "%%~L"=="" goto s_done
      Set _yyyy=%%L
      Set _mm=00%%J
      Set _dd=00%%G
      Set _hour=00%%H
      SET _minute=00%%I
      SET _second=00%%K
)
:s_done

:: Pad digits with leading zeros
      Set _mm=%_mm:~-2%
      Set _dd=%_dd:~-2%
      Set _hour=%_hour:~-2%
      Set _minute=%_minute:~-2%
      Set _second=%_second:~-2%

Set logtimestamp=%_yyyy%-%_mm%-%_dd%_%_hour%-%_minute%
goto make_dump

:s_error
echo WMIC is not available, using default log filename
Set logtimestamp=_

:make_dump
set FILENAME=hireThem_db_%logtimestamp%.sql

"D:\dev\MySQL\MySQL Server 5.7\bin\mysqldump" --user=hireThem_user --password=hireThemMySql hire_them 1>%FILENAME%

cd ..
