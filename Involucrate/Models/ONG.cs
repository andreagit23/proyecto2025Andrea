using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Involucrate.Models
{
    public class ONG
    {
        public int IdOng { get; set; }
        public int IdUsuario { get; set; }
        public string NombreOng { get; set; }
        public string Descripcion { get; set; }
        public string Direccion { get; set; }
        public string Telefono { get; set; }
        public string CorreoElectronico { get; set; }
        public string Url { get; set; }

    }
}
