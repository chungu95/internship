USE [master]
GO
/****** Object:  Database [THUCTAP]    Script Date: 8/15/2017 8:35:49 AM ******/
CREATE DATABASE [THUCTAP]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'THUCTAP', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\THUCTAP.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'THUCTAP_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\THUCTAP_log.ldf' , SIZE = 29504KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [THUCTAP] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [THUCTAP].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [THUCTAP] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [THUCTAP] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [THUCTAP] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [THUCTAP] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [THUCTAP] SET ARITHABORT OFF 
GO
ALTER DATABASE [THUCTAP] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [THUCTAP] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [THUCTAP] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [THUCTAP] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [THUCTAP] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [THUCTAP] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [THUCTAP] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [THUCTAP] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [THUCTAP] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [THUCTAP] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [THUCTAP] SET  DISABLE_BROKER 
GO
ALTER DATABASE [THUCTAP] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [THUCTAP] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [THUCTAP] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [THUCTAP] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [THUCTAP] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [THUCTAP] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [THUCTAP] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [THUCTAP] SET RECOVERY FULL 
GO
ALTER DATABASE [THUCTAP] SET  MULTI_USER 
GO
ALTER DATABASE [THUCTAP] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [THUCTAP] SET DB_CHAINING OFF 
GO
ALTER DATABASE [THUCTAP] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [THUCTAP] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
EXEC sys.sp_db_vardecimal_storage_format N'THUCTAP', N'ON'
GO
USE [THUCTAP]
GO
/****** Object:  Table [dbo].[duty]    Script Date: 8/15/2017 8:35:49 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[duty](
	[duty_id] [int] NOT NULL,
	[duty_name] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[duty_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[duty_permission]    Script Date: 8/15/2017 8:35:49 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[duty_permission](
	[permission_id] [int] NOT NULL,
	[duty_id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[permission_id] ASC,
	[duty_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[employee]    Script Date: 8/15/2017 8:35:49 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[employee](
	[emp_id] [int] IDENTITY(1,1) NOT NULL,
	[ep_address] [nvarchar](255) NULL,
	[ep_dayofbirth] [date] NULL,
	[ep_email] [nvarchar](255) NULL,
	[ep_name] [nvarchar](255) NULL,
	[ep_phone_number] [nvarchar](255) NULL,
	[user_id] [int] NULL,
	[ep_cmt] [nchar](10) NULL,
	[status] [nvarchar](255) NULL,
	[is_deleted] [int] NOT NULL CONSTRAINT [DF_employee_is_deleted]  DEFAULT ((0)),
 CONSTRAINT [PK__employee__1299A861FB3A49E4] PRIMARY KEY CLUSTERED 
(
	[emp_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[job]    Script Date: 8/15/2017 8:35:49 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[job](
	[job_id] [int] NOT NULL,
	[estimate_time] [bigint] NULL,
	[job_description] [varchar](255) NULL,
	[job_name] [varchar](255) NULL,
	[parent_id] [int] NULL,
	[phase_id] [int] NULL,
	[proj_id] [int] NULL,
	[status] [int] NULL,
	[team_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[job_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[permission]    Script Date: 8/15/2017 8:35:49 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[permission](
	[permission_id] [int] NOT NULL,
	[permission_name] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[permission_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[phase]    Script Date: 8/15/2017 8:35:49 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[phase](
	[phase_id] [int] NOT NULL,
	[description] [varchar](255) NULL,
	[estimate_time] [bigint] NULL,
	[phase_name] [varchar](255) NULL,
	[start_time] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[phase_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[phase_job]    Script Date: 8/15/2017 8:35:49 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[phase_job](
	[phase_id] [int] NOT NULL,
	[job_id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[phase_id] ASC,
	[job_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[project]    Script Date: 8/15/2017 8:35:49 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[project](
	[proj_id] [int] IDENTITY(1,1) NOT NULL,
	[create_time] [date] NULL,
	[end_time] [date] NULL,
	[pm_id] [int] NULL,
	[proj_key] [nvarchar](255) NULL,
	[proj_name] [nvarchar](255) NULL,
	[start_time] [date] NULL,
	[status] [int] NULL,
 CONSTRAINT [PK__project__A04A0C2DAE4CD0FF] PRIMARY KEY CLUSTERED 
(
	[proj_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[project_phase]    Script Date: 8/15/2017 8:35:49 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[project_phase](
	[proj_id] [int] NOT NULL,
	[phase_id] [int] NOT NULL,
	[phase_description] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[proj_id] ASC,
	[phase_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[stock]    Script Date: 8/15/2017 8:35:49 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[stock](
	[stock_id] [int] NOT NULL,
	[measurement] [varchar](255) NULL,
	[quantity] [float] NULL,
	[reserve] [float] NULL,
	[stock_name] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[stock_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[stock_employee]    Script Date: 8/15/2017 8:35:49 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[stock_employee](
	[stock_id] [int] NOT NULL,
	[emp_id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[stock_id] ASC,
	[emp_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[stock_project]    Script Date: 8/15/2017 8:35:49 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[stock_project](
	[stock_id] [int] NOT NULL,
	[proj_id] [int] NOT NULL,
	[description] [varchar](255) NULL,
	[quantity] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[stock_id] ASC,
	[proj_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tackle]    Script Date: 8/15/2017 8:35:49 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tackle](
	[tackle_id] [int] NOT NULL,
	[quantity] [int] NULL,
	[reserve] [int] NULL,
	[tck_name] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[tackle_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tackle_employee]    Script Date: 8/15/2017 8:35:49 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tackle_employee](
	[tackle_id] [int] NOT NULL,
	[emp_id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[tackle_id] ASC,
	[emp_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[team]    Script Date: 8/15/2017 8:35:49 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[team](
	[team_id] [int] NOT NULL,
	[leader_id] [int] NULL,
	[team_name] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[team_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[team_employee_job]    Script Date: 8/15/2017 8:35:49 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[team_employee_job](
	[id] [int] NOT NULL,
	[duty_id] [int] NULL,
	[end_time] [datetime2](7) NULL,
	[ep_id] [int] NULL,
	[job_id] [int] NULL,
	[start_time] [datetime2](7) NULL,
	[status] [int] NULL,
	[team_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[team_project]    Script Date: 8/15/2017 8:35:49 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[team_project](
	[team_id] [int] NOT NULL,
	[proj_id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[team_id] ASC,
	[proj_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[team_stock_employee]    Script Date: 8/15/2017 8:35:49 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[team_stock_employee](
	[id] [int] NOT NULL,
	[description] [varchar](255) NULL,
	[quantity] [float] NULL,
	[stock_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[team_tackle_employee]    Script Date: 8/15/2017 8:35:49 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[team_tackle_employee](
	[id] [int] NOT NULL,
	[description] [varchar](255) NULL,
	[quantity] [int] NULL,
	[tackle_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[users]    Script Date: 8/15/2017 8:35:49 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[users](
	[user_id] [int] IDENTITY(1,1) NOT NULL,
	[password] [varchar](255) NULL,
	[user_type] [varchar](255) NULL,
	[username] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[user_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[users_permission]    Script Date: 8/15/2017 8:35:49 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[users_permission](
	[user_id] [int] NOT NULL,
	[permission_id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[user_id] ASC,
	[permission_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[employee] ON 

INSERT [dbo].[employee] ([emp_id], [ep_address], [ep_dayofbirth], [ep_email], [ep_name], [ep_phone_number], [user_id], [ep_cmt], [status], [is_deleted]) VALUES (22, N'HCM', CAST(N'1995-02-10' AS Date), N'dsadsad@abc', N'abc', N'0988457017', 1, N'123456    ', NULL, 0)
INSERT [dbo].[employee] ([emp_id], [ep_address], [ep_dayofbirth], [ep_email], [ep_name], [ep_phone_number], [user_id], [ep_cmt], [status], [is_deleted]) VALUES (23, N'3123213213', CAST(N'2017-08-22' AS Date), N'1231312', N'1232321', N'123213213', NULL, NULL, NULL, 1)
INSERT [dbo].[employee] ([emp_id], [ep_address], [ep_dayofbirth], [ep_email], [ep_name], [ep_phone_number], [user_id], [ep_cmt], [status], [is_deleted]) VALUES (31, N'3123213213', CAST(N'2017-08-22' AS Date), N'ttt@abc', N'Trương Thanh Tình', N'123213213', 4, N'1         ', NULL, 0)
INSERT [dbo].[employee] ([emp_id], [ep_address], [ep_dayofbirth], [ep_email], [ep_name], [ep_phone_number], [user_id], [ep_cmt], [status], [is_deleted]) VALUES (49, N'31231231', CAST(N'2017-08-22' AS Date), N'nguyenhaiha435@gmail.com', N'123123', N'0986146235', NULL, N'53423     ', NULL, 1)
INSERT [dbo].[employee] ([emp_id], [ep_address], [ep_dayofbirth], [ep_email], [ep_name], [ep_phone_number], [user_id], [ep_cmt], [status], [is_deleted]) VALUES (51, N'HCM', CAST(N'2017-07-31' AS Date), N'sssssSSSSS@GMAIL.COM', N'Vu', N'098888', NULL, N'12345667  ', NULL, 1)
INSERT [dbo].[employee] ([emp_id], [ep_address], [ep_dayofbirth], [ep_email], [ep_name], [ep_phone_number], [user_id], [ep_cmt], [status], [is_deleted]) VALUES (52, N'HCM', CAST(N'2017-08-21' AS Date), N'sssssSSSSS@GMAIL.COM', N'Vũ Ðình Chung', N'000000', 28329, N'12321315  ', NULL, 0)
INSERT [dbo].[employee] ([emp_id], [ep_address], [ep_dayofbirth], [ep_email], [ep_name], [ep_phone_number], [user_id], [ep_cmt], [status], [is_deleted]) VALUES (53, N'BMT', CAST(N'2017-08-29' AS Date), N'nguyenhaiha435@gmail.com', N'Trương Thanh Tình', N'0969103075', 28330, N'1234654   ', NULL, 0)
INSERT [dbo].[employee] ([emp_id], [ep_address], [ep_dayofbirth], [ep_email], [ep_name], [ep_phone_number], [user_id], [ep_cmt], [status], [is_deleted]) VALUES (55, N'HCM', CAST(N'1997-02-28' AS Date), N'ttt@gmail.com', N'Trương Thanh Tình', N'0914073603', 28332, N'12313656  ', NULL, 0)
SET IDENTITY_INSERT [dbo].[employee] OFF
INSERT [dbo].[permission] ([permission_id], [permission_name]) VALUES (1, N'ROLE_USER')
INSERT [dbo].[permission] ([permission_id], [permission_name]) VALUES (2, N'ROLE_HR')
SET IDENTITY_INSERT [dbo].[project] ON 

INSERT [dbo].[project] ([proj_id], [create_time], [end_time], [pm_id], [proj_key], [proj_name], [start_time], [status]) VALUES (1, CAST(N'2017-08-09' AS Date), NULL, 52, N'NC4', N'Nhà cấp 4', CAST(N'2017-08-22' AS Date), 0)
INSERT [dbo].[project] ([proj_id], [create_time], [end_time], [pm_id], [proj_key], [proj_name], [start_time], [status]) VALUES (11, CAST(N'2017-08-09' AS Date), NULL, 53, N'NC3', N'Nhà cấp 3', CAST(N'2017-08-30' AS Date), 0)
SET IDENTITY_INSERT [dbo].[project] OFF
SET IDENTITY_INSERT [dbo].[users] ON 

INSERT [dbo].[users] ([user_id], [password], [user_type], [username]) VALUES (1, N'abcd', N'employee', N'12345')
INSERT [dbo].[users] ([user_id], [password], [user_type], [username]) VALUES (4, N'abcd', N'employee', N'12344')
INSERT [dbo].[users] ([user_id], [password], [user_type], [username]) VALUES (28328, N'654', N'employee', N'12352')
INSERT [dbo].[users] ([user_id], [password], [user_type], [username]) VALUES (28329, N'2017-08-21', N'employee', N'12321315')
INSERT [dbo].[users] ([user_id], [password], [user_type], [username]) VALUES (28330, N'2017-08-29', N'employee', N'1234654')
INSERT [dbo].[users] ([user_id], [password], [user_type], [username]) VALUES (28331, N'1997-02-28', N'employee', N'12312323123')
INSERT [dbo].[users] ([user_id], [password], [user_type], [username]) VALUES (28332, N'1997-02-28', N'employee', N'12313656')
SET IDENTITY_INSERT [dbo].[users] OFF
INSERT [dbo].[users_permission] ([user_id], [permission_id]) VALUES (1, 1)
INSERT [dbo].[users_permission] ([user_id], [permission_id]) VALUES (1, 2)
SET ANSI_PADDING ON

GO
/****** Object:  Index [IX_employee_cmt]    Script Date: 8/15/2017 8:35:49 AM ******/
ALTER TABLE [dbo].[employee] ADD  CONSTRAINT [IX_employee_cmt] UNIQUE NONCLUSTERED 
(
	[ep_cmt] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [IX_project]    Script Date: 8/15/2017 8:35:49 AM ******/
ALTER TABLE [dbo].[project] ADD  CONSTRAINT [IX_project] UNIQUE NONCLUSTERED 
(
	[proj_key] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UK_r43af9ap4edm43mmtq01oddj6]    Script Date: 8/15/2017 8:35:49 AM ******/
ALTER TABLE [dbo].[users] ADD  CONSTRAINT [UK_r43af9ap4edm43mmtq01oddj6] UNIQUE NONCLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UKr43af9ap4edm43mmtq01oddj6]    Script Date: 8/15/2017 8:35:49 AM ******/
ALTER TABLE [dbo].[users] ADD  CONSTRAINT [UKr43af9ap4edm43mmtq01oddj6] UNIQUE NONCLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[duty_permission]  WITH CHECK ADD  CONSTRAINT [FK4lnewjfcahpf09yskr5vfmeck] FOREIGN KEY([duty_id])
REFERENCES [dbo].[duty] ([duty_id])
GO
ALTER TABLE [dbo].[duty_permission] CHECK CONSTRAINT [FK4lnewjfcahpf09yskr5vfmeck]
GO
ALTER TABLE [dbo].[duty_permission]  WITH CHECK ADD  CONSTRAINT [FKcgd2jagep46ex0372f6wxdbba] FOREIGN KEY([permission_id])
REFERENCES [dbo].[permission] ([permission_id])
GO
ALTER TABLE [dbo].[duty_permission] CHECK CONSTRAINT [FKcgd2jagep46ex0372f6wxdbba]
GO
ALTER TABLE [dbo].[employee]  WITH CHECK ADD  CONSTRAINT [FKhal2duyxxjtadykhxos7wd3wg] FOREIGN KEY([user_id])
REFERENCES [dbo].[users] ([user_id])
GO
ALTER TABLE [dbo].[employee] CHECK CONSTRAINT [FKhal2duyxxjtadykhxos7wd3wg]
GO
ALTER TABLE [dbo].[job]  WITH CHECK ADD  CONSTRAINT [FK22fdh6axubapkometg3ti0dlg] FOREIGN KEY([proj_id])
REFERENCES [dbo].[project] ([proj_id])
GO
ALTER TABLE [dbo].[job] CHECK CONSTRAINT [FK22fdh6axubapkometg3ti0dlg]
GO
ALTER TABLE [dbo].[job]  WITH CHECK ADD  CONSTRAINT [FKm3ran8skjnmjj1glyn6yi30t5] FOREIGN KEY([phase_id])
REFERENCES [dbo].[phase] ([phase_id])
GO
ALTER TABLE [dbo].[job] CHECK CONSTRAINT [FKm3ran8skjnmjj1glyn6yi30t5]
GO
ALTER TABLE [dbo].[job]  WITH CHECK ADD  CONSTRAINT [FKssc3s7m4dmh4anjx9s9qok33w] FOREIGN KEY([parent_id])
REFERENCES [dbo].[job] ([job_id])
GO
ALTER TABLE [dbo].[job] CHECK CONSTRAINT [FKssc3s7m4dmh4anjx9s9qok33w]
GO
ALTER TABLE [dbo].[phase_job]  WITH CHECK ADD  CONSTRAINT [FKhjs0v131f3vvwobaie2rnymf6] FOREIGN KEY([phase_id])
REFERENCES [dbo].[phase] ([phase_id])
GO
ALTER TABLE [dbo].[phase_job] CHECK CONSTRAINT [FKhjs0v131f3vvwobaie2rnymf6]
GO
ALTER TABLE [dbo].[phase_job]  WITH CHECK ADD  CONSTRAINT [FKobiyaw4xd5c7xmpur2g4695ft] FOREIGN KEY([job_id])
REFERENCES [dbo].[job] ([job_id])
GO
ALTER TABLE [dbo].[phase_job] CHECK CONSTRAINT [FKobiyaw4xd5c7xmpur2g4695ft]
GO
ALTER TABLE [dbo].[project_phase]  WITH CHECK ADD  CONSTRAINT [FKg50uhnsxfwqn9bmcpe3bon2kc] FOREIGN KEY([proj_id])
REFERENCES [dbo].[project] ([proj_id])
GO
ALTER TABLE [dbo].[project_phase] CHECK CONSTRAINT [FKg50uhnsxfwqn9bmcpe3bon2kc]
GO
ALTER TABLE [dbo].[project_phase]  WITH CHECK ADD  CONSTRAINT [FKi6bmgi6ef0d8kf28o5tio5pot] FOREIGN KEY([phase_id])
REFERENCES [dbo].[phase] ([phase_id])
GO
ALTER TABLE [dbo].[project_phase] CHECK CONSTRAINT [FKi6bmgi6ef0d8kf28o5tio5pot]
GO
ALTER TABLE [dbo].[stock_employee]  WITH CHECK ADD  CONSTRAINT [FK5yjje7lrr4enwqney59jmnjkw] FOREIGN KEY([emp_id])
REFERENCES [dbo].[employee] ([emp_id])
GO
ALTER TABLE [dbo].[stock_employee] CHECK CONSTRAINT [FK5yjje7lrr4enwqney59jmnjkw]
GO
ALTER TABLE [dbo].[stock_employee]  WITH CHECK ADD  CONSTRAINT [FK6hyv52e4kfmivogpr395598xw] FOREIGN KEY([stock_id])
REFERENCES [dbo].[stock] ([stock_id])
GO
ALTER TABLE [dbo].[stock_employee] CHECK CONSTRAINT [FK6hyv52e4kfmivogpr395598xw]
GO
ALTER TABLE [dbo].[stock_project]  WITH CHECK ADD  CONSTRAINT [FKcdge53wh0vppvf0sxlwxspkt4] FOREIGN KEY([proj_id])
REFERENCES [dbo].[project] ([proj_id])
GO
ALTER TABLE [dbo].[stock_project] CHECK CONSTRAINT [FKcdge53wh0vppvf0sxlwxspkt4]
GO
ALTER TABLE [dbo].[stock_project]  WITH CHECK ADD  CONSTRAINT [FKlieuimdxa1ft4axw5msny1xcv] FOREIGN KEY([stock_id])
REFERENCES [dbo].[stock] ([stock_id])
GO
ALTER TABLE [dbo].[stock_project] CHECK CONSTRAINT [FKlieuimdxa1ft4axw5msny1xcv]
GO
ALTER TABLE [dbo].[tackle_employee]  WITH CHECK ADD  CONSTRAINT [FKjh5tkdfdd1kakxaaxrarj3uq4] FOREIGN KEY([emp_id])
REFERENCES [dbo].[employee] ([emp_id])
GO
ALTER TABLE [dbo].[tackle_employee] CHECK CONSTRAINT [FKjh5tkdfdd1kakxaaxrarj3uq4]
GO
ALTER TABLE [dbo].[tackle_employee]  WITH CHECK ADD  CONSTRAINT [FKnlnul1138rfp4pe5eecbu9jvt] FOREIGN KEY([tackle_id])
REFERENCES [dbo].[tackle] ([tackle_id])
GO
ALTER TABLE [dbo].[tackle_employee] CHECK CONSTRAINT [FKnlnul1138rfp4pe5eecbu9jvt]
GO
ALTER TABLE [dbo].[team_employee_job]  WITH CHECK ADD  CONSTRAINT [FKa0xmdjadvqonmsrsjxqu1xw8b] FOREIGN KEY([job_id])
REFERENCES [dbo].[job] ([job_id])
GO
ALTER TABLE [dbo].[team_employee_job] CHECK CONSTRAINT [FKa0xmdjadvqonmsrsjxqu1xw8b]
GO
ALTER TABLE [dbo].[team_employee_job]  WITH CHECK ADD  CONSTRAINT [FKboph8gna4e8f3euipr0jjocgb] FOREIGN KEY([team_id])
REFERENCES [dbo].[duty] ([duty_id])
GO
ALTER TABLE [dbo].[team_employee_job] CHECK CONSTRAINT [FKboph8gna4e8f3euipr0jjocgb]
GO
ALTER TABLE [dbo].[team_employee_job]  WITH CHECK ADD  CONSTRAINT [FKn22k4a1k3i7nv07bbhvwir88i] FOREIGN KEY([ep_id])
REFERENCES [dbo].[employee] ([emp_id])
GO
ALTER TABLE [dbo].[team_employee_job] CHECK CONSTRAINT [FKn22k4a1k3i7nv07bbhvwir88i]
GO
ALTER TABLE [dbo].[team_project]  WITH CHECK ADD  CONSTRAINT [FKelq27u0x7m0ku0t7sg5pfdqi0] FOREIGN KEY([team_id])
REFERENCES [dbo].[team] ([team_id])
GO
ALTER TABLE [dbo].[team_project] CHECK CONSTRAINT [FKelq27u0x7m0ku0t7sg5pfdqi0]
GO
ALTER TABLE [dbo].[team_project]  WITH CHECK ADD  CONSTRAINT [FKtrv1gj7y8xj9ffwvgjyi9le94] FOREIGN KEY([proj_id])
REFERENCES [dbo].[project] ([proj_id])
GO
ALTER TABLE [dbo].[team_project] CHECK CONSTRAINT [FKtrv1gj7y8xj9ffwvgjyi9le94]
GO
ALTER TABLE [dbo].[team_stock_employee]  WITH CHECK ADD  CONSTRAINT [FKt9o5boc23cwamewbck6l81l93] FOREIGN KEY([stock_id])
REFERENCES [dbo].[stock] ([stock_id])
GO
ALTER TABLE [dbo].[team_stock_employee] CHECK CONSTRAINT [FKt9o5boc23cwamewbck6l81l93]
GO
ALTER TABLE [dbo].[team_tackle_employee]  WITH CHECK ADD  CONSTRAINT [FKpr6k0qbuuawpf2f9ll9korkvx] FOREIGN KEY([tackle_id])
REFERENCES [dbo].[tackle] ([tackle_id])
GO
ALTER TABLE [dbo].[team_tackle_employee] CHECK CONSTRAINT [FKpr6k0qbuuawpf2f9ll9korkvx]
GO
ALTER TABLE [dbo].[users_permission]  WITH CHECK ADD  CONSTRAINT [FK1433hsl1uh86bv8xequx32fe2] FOREIGN KEY([user_id])
REFERENCES [dbo].[users] ([user_id])
GO
ALTER TABLE [dbo].[users_permission] CHECK CONSTRAINT [FK1433hsl1uh86bv8xequx32fe2]
GO
ALTER TABLE [dbo].[users_permission]  WITH CHECK ADD  CONSTRAINT [FKb82qqsid64oxt3r7uutoooe8y] FOREIGN KEY([permission_id])
REFERENCES [dbo].[permission] ([permission_id])
GO
ALTER TABLE [dbo].[users_permission] CHECK CONSTRAINT [FKb82qqsid64oxt3r7uutoooe8y]
GO
USE [master]
GO
ALTER DATABASE [THUCTAP] SET  READ_WRITE 
GO
