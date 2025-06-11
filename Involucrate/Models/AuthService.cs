using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Involucrate.Models
{
    // AuthService.cs
    public static class AuthService
    {
        private static Usuario usuarioLogueado;

        public static void Login(Usuario usuario)
        {
            usuarioLogueado = usuario;
        }

        public static Usuario GetUsuarioLogueado()
        {
            return usuarioLogueado;
        }
    }

}
