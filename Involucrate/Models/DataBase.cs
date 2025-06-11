using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Involucrate.Models
{
    public static class Database
    {
        private static string connectionString = "Server=localhost;Port=3307;Database=involucrate;Uid=root;Pwd=8114;";

        public static MySqlConnection GetConnection()
        {
            return new MySqlConnection(connectionString);
        }
    }

}
