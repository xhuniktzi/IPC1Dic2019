#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

typedef struct nodo{
    int codigo;
    char nombre[24];
    int edad;
    int telefono;

    struct nodo* sig;
    struct nodo* ant;
} nodo;

nodo* ini = NULL;
nodo* end = NULL;

void insertarNodo();
void imprimir();
void modificarNodo();
void eliminarNodo();

int main(){
    bool flag = true;

    while (flag){
        int opt;
        printf("\n");
        printf("1.- Insertar registro al frente\n");
        printf("2.- Mostrar\n");
        printf("3.- Modificar\n");
        printf("4.- Eliminar\n");
        printf("5.- Salir\n");
        scanf("%i",&opt);
        if (opt == 1){
            insertarNodo();
        }
        if (opt == 2){
            imprimir();
        }
        if (opt == 3){
            modificarNodo();
        }
        if (opt == 4){
            eliminarNodo();
        }
        if (opt == 5){
            flag = false;
        }
        if (opt > 5 || opt <= 0){
            printf("Ingresa una opcion valida\n");
        }
    }
    return 0;
}

void insertarNodo(){
    nodo* nuevo = (nodo*) malloc(sizeof(nodo));
    printf("Ingrese datos:\n");
    printf("ingresa el nombre: ");
    scanf("%s", &nuevo->nombre);

    printf("ingresa la edad: ");
    scanf("%i", &nuevo->edad);

    printf("ingresa el telefono: ");
    scanf("%i", &nuevo->telefono);

    printf("ingresa el codigo: ");
    scanf("%i", &nuevo->codigo);

    if (ini == NULL){
        ini = nuevo;
        ini->sig = NULL;
        ini->ant = NULL;
        end = ini;
    } else {
        end->sig = nuevo;
        nuevo->sig = NULL;
        nuevo->ant = end;
        end = nuevo;
    }
}

void imprimir(){
    nodo* act = (nodo*) malloc(sizeof(nodo));
    act = ini;
    if (ini != NULL){
        while (act != NULL){
            printf("\n");
            printf("Nombre: %s\n",act->nombre);
            printf("Edad: %i\n",act->edad);
            printf("Telefono: %i\n",act->telefono);
            printf("Codigo: %i\n",act->codigo);
            printf("\n");
            act = act->sig;
        }
    }else {
        printf("Lista vacia\n");
    }
}

void modificarNodo(){
    nodo* act = (nodo*) malloc(sizeof(nodo));
    int codigoBuscado = 0;
    bool estadoConsulta = false;

    act = ini;
    if (ini != NULL){
        printf("Ingrese el codigo del registro a modificar\n");
        scanf("%i",&codigoBuscado);
        while (act != NULL && estadoConsulta != true){
            if (act ->codigo == codigoBuscado){
                printf("Modificando registro %i:\n",codigoBuscado);

                printf("ingresa el nombre: ");
                scanf("%s", &act->nombre);

                printf("ingresa la edad: ");
                scanf("%i", &act->edad);

                printf("ingresa el telefono: ");
                scanf("%i", &act->telefono);
                estadoConsulta = true;
            }
            act = act->sig;
        }
        if (!estadoConsulta){
            printf("no existe un registro con ese codigo");
        }
    }else {
        printf("Lista vacia\n");
    }
}

void eliminarNodo(){
    nodo* act = (nodo*) malloc(sizeof(nodo));
    nodo* prev = (nodo*) malloc(sizeof(nodo));
    act = ini;
    prev = NULL;
    int codigoBuscado = 0;
    bool estadoConsulta = false;

    
    if (ini != NULL){
        printf("Ingrese el codigo del registro a eliminar\n");
        scanf("%i",&codigoBuscado);
        while (act != NULL && estadoConsulta != true){
            if (act ->codigo == codigoBuscado){
                if (ini == end){
                    ini = NULL;
                    end = NULL;
                    return;
                }


                if(act == ini){
                    ini = ini->sig;
                    ini->ant = NULL;
                    return;
                } else if (act == end){
                    prev->sig = NULL;
                    end = prev;
                    return;
                } else {
                    prev->sig = act->sig;
                    act->sig->ant = prev;
                    return;
                }

                estadoConsulta = true;
            }
            prev = act;
            act = act->sig;
        }
        if (!estadoConsulta){
            printf("no existe un registro con ese codigo");
        }
    }else {
        printf("Lista vacia\n");
    }
}