#include <stdio.h>


    int elevarCubo ( int x ) {
        return x*x*x ;
    }

    int calcSum ( int n) {
        int acum =0;
        int i ;
        for ( i =1; i<=n ; i ++){
        acum = acum + elevarCubo ( i );
        }
    return acum;
    }

void main ( ) {

    int n ;

    printf ( "Sumar enteros hasta : " ) ;
    scanf ( "%d" ,&n ) ;
    int sum = calcSum ( n ) ;
    printf( "Sum es %d\n" , sum ) ;

    }



