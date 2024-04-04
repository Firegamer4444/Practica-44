# defino un metodo que pide un dni y busca la linea donde esta ese dni
def busqueda_dni(fichero):
    dni = str(input("Introduzca el dni que quieres buscar: "))
    for linea in fichero:
        # se establece un condicional que compara el dni introducido con el dni de cada linea del txt
        if dni == linea[:9]:
            return linea
    print("\nEl dni introducido no existe")
    
# defino un metodo para imprimir los datos de una linea
def imprimir_datos(linea):
    linea_c = linea.split(",")
    nombre = linea_c[1]
    apellidos = linea_c[2]
    correo = linea_c[3]
    print("nombre: " , nombre)
    print("apellidos: " , apellidos)
    print("correo: " , correo)
    
# defino el metodo del menu
def menu(fichero):
    while True:
        print("\n--- Opciones: ---")
        print("1. Buscar usuario por DNI")
        print("2. cerrar programa")
        opcion = input("Seleccione una opción: ")
        # si se elije la opcion 1 se llama al metodo de buscar dni y luego al metodo de imprimir los datos
        if opcion == '1':
            linea_actual = busqueda_dni(fichero)
            # se comprueba que la salida del metodo busqued_dni no sea null por haber introducido un dni inexistente
            if linea_actual != None:
                 imprimir_datos(linea_actual)
            else:
                print("\nVuelva a elejir una opcion")
        # si se elije la segunda opcion se cierra el programa
        elif opcion == '2':
            return
    


fichero = open('usuarios.txt' , 'r' , encoding='utf-8')
menu(fichero)
fichero.close()