%{
int linecount = 0;
int charcount = 0;
int i=0;
%}

%%

([a-zA-Z0-9])*    {i++; charcount=charcount+yyleng;}
\n {linecount++; charcount++;}


%%
int yywrap(){return(1);}
void main()
{
	printf("Enter your text:\n");
	yylex();
	printf("\nNo. of lines = %d \nNo. of words = %d \nNo. of characters = %d\n\n", linecount, i, charcount);
} 
